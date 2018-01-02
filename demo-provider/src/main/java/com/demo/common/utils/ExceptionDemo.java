package com.demo.common.utils;


public class ExceptionDemo {

	
	public static void main(String[] args) {
		try{
			String a = null;
			int b = a.length();
			throw new Exception("123");
		}catch(Exception e){
			
		}
	}
}
