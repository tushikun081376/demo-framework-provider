package com.taiji.common.utils;

import org.apache.log4j.Logger;


public class ExceptionDemo {

	private static Logger log = Logger.getLogger(ExceptionDemo.class);
	
	public static void main(String[] args) {
		try{
			throw new Exception("123");
		}catch(Exception e){
			log.debug(e.getMessage(),e);
		}
	}
}
