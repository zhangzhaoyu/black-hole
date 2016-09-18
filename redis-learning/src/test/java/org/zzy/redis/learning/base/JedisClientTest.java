package org.zzy.redis.learning.base;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.Transaction;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by zhaoyu on 16-9-13.
 */
public class JedisClientTest {

    private static final String REDIS_KEYEVENT_PREFIX = "__keyevent@0__:*";

    protected static HostAndPort hostAndPort = HostAndPortUtil.getRedisServers().get(0);
    final byte[] bfoo = { 0x01, 0x02, 0x03, 0x04 };
    final byte[] bbar = { 0x05, 0x06, 0x07, 0x08 };
    final byte[] ba = { 0x0A };
    final byte[] bb = { 0x0B };
    final byte[] bmykey = { 0x42, 0x02, 0x03, 0x04 };

    private Jedis jedis;

    @Before
    public void before() {
        jedis = new Jedis(hostAndPort.getHost(), hostAndPort.getPort());
        jedis.auth("Anicl0ud");
    }

    @Test
    public void testNormal() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            jedis.set(Integer.toString(i), Integer.toString(i + 1));
        }
        long end = System.currentTimeMillis();
        System.out.println("set times per second : " + 100000 / ((end - start) / 1000.0));
        jedis.flushDB();
        jedis.disconnect();
    }

    @Test
    public void multi() {
        jedis.flushDB();
        Transaction trans = jedis.multi();

        trans.sadd("foo", "a");
        trans.sadd("foo", "b");
        trans.scard("foo");

        List<Object> response = trans.exec();

        List<Object> expected = new ArrayList<Object>();
        expected.add(1L);
        expected.add(1L);
        expected.add(2L);
        assertEquals(expected, response);

        // Binary
        trans = jedis.multi();

        trans.sadd(bfoo, ba);
        trans.sadd(bfoo, bb);
        trans.scard(bfoo);

        response = trans.exec();

        expected = new ArrayList<Object>();
        expected.add(1L);
        expected.add(1L);
        expected.add(2L);
        assertEquals(expected, response);

    }

    @Test
    public void watch() throws UnknownHostException, IOException {
        jedis.watch("mykey", "somekey");
        Transaction t = jedis.multi();

        Jedis nj = new Jedis("localhost");
        nj.connect();
        nj.auth("Anicl0ud");
        nj.set("mykey", "bar");
        nj.disconnect();

        t.set("mykey", "foo");
        List<Object> resp = t.exec();
        //assertEquals(null, resp);
        assertEquals("bar", jedis.get("mykey"));

        // Binary
        jedis.watch(bmykey, "foobar".getBytes());
        t = jedis.multi();

        nj.connect();
        nj.auth("Anicl0ud");
        nj.set(bmykey, bbar);
        nj.disconnect();

        t.set(bmykey, bfoo);
        resp = t.exec();
        assertEquals(null, resp);
        assertTrue(Arrays.equals(bbar, jedis.get(bmykey)));
    }

    @Test
    public void testPubSub() {
        jedis.subscribe(new NewListener(), "hello");
    }

    @Test
    public void testPub() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            jedis.publish("hello", "xxx--xx : " + i);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Test
    public void testRedisKeySpaceNotification() {
        jedis.psubscribe(new NewListener(), REDIS_KEYEVENT_PREFIX);
    }

    @Test
    public void testRedisKeySpace() {
        jedis.set("zhang", "zhaoyu");
        jedis.expire("zhang", 5);
    }

}

class NewListener extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        System.out.println(String.format("receive redis published message, channel %s, message %s", channel, message));
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("channel " + channel + ";subscribedChannels " + subscribedChannels);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println(pattern + " : " + channel + " : " + message);
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println(pattern + " : " + subscribedChannels);
    }
}
