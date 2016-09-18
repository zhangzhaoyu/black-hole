package org.zzy.redis.learning.spring;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.net.URL;

/**
 * Created by zhaoyu on 16-9-13.
 */
public class ClassPathResourceTest {
    public static void main(String[] args) throws IOException {
        ClassPathResource resource = new ClassPathResource("logback.xml");
        System.out.println(resource.getPath());
        System.out.println(resource.getURL().getPath());
        URL url = ClassPathResourceTest.class.getClassLoader().getResource("logback.xml");
        System.out.println(ClassPathResourceTest.class.getResource("ClassPathResourceTest.class").getPath());
        System.out.println(url.getPath());
    }
}
