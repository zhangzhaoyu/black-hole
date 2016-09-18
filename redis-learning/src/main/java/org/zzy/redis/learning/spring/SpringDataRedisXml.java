package org.zzy.redis.learning.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by zhaoyu on 16-9-13.
 */
public class SpringDataRedisXml {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:/application-context/redis/redis.xml");

        RedisTemplate<String, String> redisTemplate = applicationContext.getBean(RedisTemplate.class);
        redisTemplate.opsForValue().set("hello", "redis template xml");
        System.out.println(redisTemplate.opsForValue().get("hello"));
    }
}
