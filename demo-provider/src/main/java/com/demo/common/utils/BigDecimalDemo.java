package com.demo.common.utils;

import java.math.BigDecimal;

public class BigDecimalDemo {
	public static void main(String[] args) {
		System.out.println((new BigDecimal("000000033800").divide(new BigDecimal("100"))).setScale(2, BigDecimal.ROUND_HALF_UP));
	}
}
