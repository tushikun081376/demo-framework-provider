package com.taiji.common.utils;

public class VariableParameterDemo {

	/**
	 * 可变参数
	 * @param numbers
	 * @return
	 */
	public static int sum(int... numbers){
		int sum = 0;
		for(int number : numbers){
			sum +=number;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(sum(1));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3));
		System.out.println(sum(1,2,3,4));
	}
}
