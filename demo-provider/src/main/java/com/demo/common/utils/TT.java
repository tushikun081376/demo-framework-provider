package com.demo.common.utils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class TT {
	/**
	 * 取得一个信任任何证书的Https链接
	 * @param url
	 * @return
	 * @throws Exception
	 */
	private static HttpsURLConnection getInstance(String url) throws Exception{
		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				return true;
			}
		};
		trustAllHttpsCertificates();
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
		URL urlTmp = new URL(url);
		return (HttpsURLConnection) urlTmp.openConnection();
	}
	/**
	 * 信任所有的证书
	 * 
	 * @throws Exception
	 */
	private static void trustAllHttpsCertificates() throws Exception {
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}
	static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}
		public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
			return true;
		}
		public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
			return true;
		}
		public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}
		public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}
	}
	/**
	 * http/https post
	 * @param url
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public byte [] doPost(String url,byte [] data) throws Exception {
		URLConnection con = null;
		OutputStream os = null;
		InputStream is = null;
		ByteArrayOutputStream bos = null;
		DataOutputStream dos = null;
		try {
			URL dataUrl = new URL(url);
			if (url.startsWith("https")) {
				con = getInstance(url);
			} else {
				con = (HttpURLConnection) dataUrl.openConnection();
			}
			con.setDoInput(true);
			con.setDoOutput(true);
			if(data!= null && data.length >0){
				con.setDoOutput(true);
				os = con.getOutputStream();
				os.write(data);
				os.close();
				os = null;
			}
			is = con.getInputStream();
			byte[] b = new byte[1024];
			int len = -1;
			bos = new ByteArrayOutputStream();
			dos = new DataOutputStream(bos);
			while ((len = is.read(b)) != -1) {
				dos.write(b, 0, len);
			}
			b = bos.toByteArray();
			return b;
		} catch (Exception e) {
			throw e;
		} finally {
			try {if (is != null)is.close();} catch (Exception e) {}
			try {if (os != null){os.flush();os.close();}} catch (Exception e) {}
			try {if (dos != null)dos.close();} catch (Exception e) {}
			try {if (bos != null)bos.close();} catch (Exception e) {}
			try {closeURLConnection(con);} catch (Exception e) {}
		}
	}
	private void closeURLConnection(URLConnection con) {
		if (con instanceof HttpURLConnection) {
			((HttpURLConnection) con).disconnect();
		} else if (con instanceof HttpsURLConnection) {
			((HttpsURLConnection) con).disconnect();
		}
	}
	public static void main(String [] args) throws UnsupportedEncodingException, Exception{
		String url = "http://www.huacai.com.cn/index.php?m=vote&c=index&a=lists&siteid=1";
		String a = URLEncoder.encode("");
		String resp = new String(new TT().doPost(url,a.getBytes()),"gbk");
		resp = resp.replaceAll("\\s*", "");
		System.out.println(resp);
		int index = resp.indexOf("A086");
		System.out.println(index);
		String b = resp.substring(index, index+500);
		System.out.println(b);
		int index1 = b.indexOf("name=\"form_token\"value=\"");
		int index2 = b.indexOf("\"></form>");
		String value = b.substring(index1+24, index2);
		System.out.println(value);
		
		String url1 = "http://www.huacai.com.cn/index.php?m=vote&c=index&a=postada&subjectid=2&siteid=1";
		String c = URLEncoder.encode("&form_token="+value+"&radio[]=189&subjectid=2");
		String resp1 = new String(new TT().doPost(url1,c.getBytes()),"utf-8");
		System.out.println(resp1);
	}
}