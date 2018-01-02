package com.demo.common.utils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ASFF {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("api_ticket", "IpK_1T69hDhZkLQTlwsAX2zxpVIlLPzWsBrz5beo6smbs1BxLpZ9Lcqcmrhz2JeUQnIxGXMrcjtQNa4M9oU18g");
		map.put("card_id", "plgEOwXfFJ3dTG4Si1CeJRd4sYJA");
		map.put("code", "11111111111111111111111");
		map.put("noncestr", "305f0227-5e18-49c4-98fd-3ec9d4b50895");
		map.put("timestamp", "1507804946");

		String[] str = {"code", "timestamp", "card_id", "api_ticket", "noncestr" };
		String[] valStr = new String[str.length];
		String url = "";
		for (int i = 0; i < str.length; i++) {
			valStr[i] = map.get(str[i]);
		}
		Arrays.sort(valStr);
		System.out.println(Arrays.toString(valStr));
	}
}
