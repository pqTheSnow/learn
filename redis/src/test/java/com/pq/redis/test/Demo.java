package com.pq.redis.test;

import com.pq.redis.RedisApplication;
import com.pq.redis.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class Demo {

    @Autowired
    private TestService testService;

    @Test
    public void springBootTest(){
        testService.test();
    }

}
