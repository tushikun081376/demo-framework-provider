package redis.clients.jedis;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRedisClient {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(RedisClient.getClient().set("key","123456"));
		System.out.println(RedisClient.getClient().get("key"));
		System.out.println(RedisClient.getClient().get("1"));
		System.out.println(RedisClient.getClient().get("2"));
		System.out.println(RedisClient.getClient().get("3"));
	}

}