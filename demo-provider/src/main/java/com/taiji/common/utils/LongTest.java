package com.taiji.common.utils;


import java.math.BigDecimal;

public class LongTest {
	public static void main(String[] args) {
		Long a = new Long(1);
		Long b = new Long(2);
		Long c = a- b;
		System.out.println(c);
		
		BigDecimal d = new BigDecimal(0);
		System.out.println(d.equals(new BigDecimal(0)));
		System.out.println(d.compareTo(BigDecimal.ZERO));
	}
}
