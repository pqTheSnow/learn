package com.pq.redis;

import com.pq.redis.components.jedis.JedisUtil;
import com.pq.redis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class RedisApplication implements CommandLineRunner {
    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(RedisApplication.class, args)));
    }

    @Autowired
    private TestService testService;

    @Autowired
    private JedisUtil redis;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("redis start run");

        testService.test();

        System.out.println("redis stop run");
    }

}
