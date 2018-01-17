package com.taiji.common.utils;

public class StringDemo {

	private static String name = "lucy";
	
	private static String username = new String("lucy");
	
	public static void main(String[] args) {
		System.out.println(name.hashCode());
		System.out.println(username.hashCode());
		System.out.println(name == username);
		System.out.println(name.equals(username));
		
	}
	
}
