package redis.clients.jedis;

import redis.clients.jedis.Jedis;

public class RedisClient {
	
	//redis主机IP地址
	public static final String HOST = "127.0.0.1";
	//redis主机端口
	public static final Integer PORT = 6379;
	
	public static Jedis jedis = null;
	
	public static Jedis getClient(){
		if(jedis == null){
			jedis = new Jedis(HOST, PORT);
		}
		return jedis;
	}
}