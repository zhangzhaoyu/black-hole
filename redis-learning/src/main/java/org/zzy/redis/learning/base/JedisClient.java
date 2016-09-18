package org.zzy.redis.learning.base;

import redis.clients.jedis.Jedis;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

/**
 * Created by zhaoyu on 16-9-7.
 */
public class JedisClient {
    private static Jedis jedis = new Jedis("localhost");

    public void stringOperate() {
        System.out.println(jedis.set("hello", "world"));
    }

    public void listOperate() {
        System.out.println(jedis.lpush("list", "hello world!!"));
    }

    public void getAllKeys() {
        Set<String> keySet = jedis.keys("*");
        for (String key : keySet) {
            System.out.println("key:" + key);
            List<String> list = jedis.lrange("list", 0, -1);
            System.out.println(list.toString());
        }
    }

    public void testSetPerSecond(int times) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            jedis.set(Integer.toString(i), Integer.toString(i));
        }
        long end = System.currentTimeMillis();
        double setPerSecond = times * 1000 / (double)(end - begin);
        System.out.println("set per second : " + setPerSecond);
    }

    public static void main(String[] args) throws UnknownHostException {
        JedisClient jedisClient = new JedisClient();
        /*jedisClient.stringOperate();
        jedisClient.listOperate();
        jedisClient.getAllKeys();*/

        jedisClient.testSetPerSecond(100000);
    }

}
