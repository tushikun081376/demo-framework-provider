package com.demo.common.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA2 {
	public static String SHA1(String decript) {
		try {
			MessageDigest digest = java.security.MessageDigest
					.getInstance("SHA-1");
			digest.update(decript.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) {
		String data = "jsapi_ticket=kgt8ON7yVITDhtdwci0qedEdQfl_o33tjP661fvsw6WBVtTB1ldtwHTwFVVfYQrJcK7umG68Sqq37Pvkv2FL6A&noncestr=48f8c386-9cf7-4ddb-9d54-3e45ed55cc89&timestamp=1507797353&url=http://kfweixin.etaoko.com/wechatpublic-adminweb/serverpage/wechatpublic/getcard.jsp";
		System.out.println(data);
		String digest = new SHA1().getDigestOfString(data.getBytes());
		System.out.println(digest);
		//b67db77f6733306023496011568896940e0e32b9
		// System.out.println( ToMD5.convertSHA1(data).toUpperCase());
	}
}
