package demos;


import java.util.Random;

public class RandomTest {

	public static String random(int n) {
		if (n < 1 || n > 10){
			throw new IllegalArgumentException((new StringBuilder(
					"cannot random ")).append(n).append(" bit number")
					.toString());
		}
		Random ran = new Random();
		if (n == 1){
			System.out.println(ran.nextInt(10));
			return String.valueOf(ran.nextInt(10));
		}
		String tmp_s = "";
		for (int i = 0; i < n; i++){
			tmp_s = (new StringBuilder(String.valueOf(tmp_s))).append(
					ran.nextInt(10)).toString();
			System.out.println(tmp_s);
		}
		return new String(tmp_s);
	}
	
	public static void main(String[] args) {
		//nextInt() 该方法的作用是生成一个随机的int值，该值介于int的区间，也就是-231到231-1之间。
		//nextInt(n) 该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
		System.out.println(random(8));
	}

}
