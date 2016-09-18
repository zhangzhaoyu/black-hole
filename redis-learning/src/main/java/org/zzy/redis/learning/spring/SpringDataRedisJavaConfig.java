package org.zzy.redis.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by zhaoyu on 16-9-13.
 */
@Configuration
public class SpringDataRedisJavaConfig {

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        return jedisPoolConfig;
    }

    @Bean
    public JedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
        redisConnectionFactory.setPassword("Anicl0ud");
        return redisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        return redisTemplate;
    }
}

class SpringDataRedisJava {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringDataRedisJavaConfig.class);
        RedisTemplate<String, String> redisTemplate = applicationContext.getBean(RedisTemplate.class);
        redisTemplate.opsForValue().set("hello", "springRedisJavaConfig");
        System.out.println(redisTemplate.opsForValue().get("hello"));
    }
}
