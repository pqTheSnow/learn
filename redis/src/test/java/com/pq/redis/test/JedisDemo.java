package com.pq.redis.test;

import com.pq.redis.RedisApplication;
import com.pq.redis.components.jedis.JedisUtil;
import com.pq.redis.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class JedisDemo {

    @Autowired
    private JedisUtil redis;

    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void jedisTest(){
        String key = "test";
        redis.set(key, "hhhaaa");
        System.out.println(redis.get(key));
        redis.del(key);
        System.out.println(redis.get(key));
    }
    @Test
    public void jedisClusterTest(){
        String key = "test";
        jedisCluster.set(key, "hhhaaa");
        System.out.println(jedisCluster.get(key));
        jedisCluster.del(key);
        System.out.println(jedisCluster.get(key));
        jedisCluster.close();
    }

    @Test
    public void redisDistributedLock(){
        // TODO 实现分布式锁
    }

}
