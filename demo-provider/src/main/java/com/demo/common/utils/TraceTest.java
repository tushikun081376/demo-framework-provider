package com.demo.common.utils;


public class TraceTest {
	
	public static String getTraceInfo() {
		StringBuffer sb = new StringBuffer();

		StackTraceElement[] stacks = new Throwable().getStackTrace();
		int stacksLen = stacks.length;
		sb.append("class: ").append(stacks[1].getClassName())
				.append("; method: ").append(stacks[1].getMethodName())
				.append("; number: ").append(stacks[1].getLineNumber());

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getTraceInfo());
//		异常处理
//		String _methodName = new Exception().getStackTrace()[1].getMethodName();// 获得调用者的方法名
//		String _thisMethodName = new Exception().getStackTrace()[0].getMethodName();// 获得当前的方法名
//		System.out.println(_methodName);
//		System.out.println(_thisMethodName);

	}
	
	
}
