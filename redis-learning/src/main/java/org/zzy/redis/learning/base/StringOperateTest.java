package org.zzy.redis.learning.base;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by zhaoyu on 16-9-14.
 */
public class StringOperateTest {
    private Jedis jedis;

    @Before
    public void before() {
        jedis = new Jedis("localhost");
        jedis.auth("Anicl0ud");
    }

    @Test
    public void testStringOperate() {
        System.out.println(jedis.incr("key"));
        System.out.println(jedis.incrBy("key", 10));
        System.out.println(jedis.incrByFloat("float", 2.22));
    }
}
