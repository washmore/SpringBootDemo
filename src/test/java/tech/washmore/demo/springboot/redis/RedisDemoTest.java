package tech.washmore.demo.springboot.redis;

import org.apache.tomcat.jni.Time;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import tech.washmore.demo.springboot.BaseTest;

import javax.annotation.Resource;
import javax.management.timer.TimerMBean;
import java.util.Timer;
import java.util.concurrent.TimeUnit;


public class RedisDemoTest extends BaseTest {

    @Autowired
    private RedisDemo redisDemo;

    @Test
    public void testGetCurrentTime() throws InterruptedException {
        String t1 = redisDemo.getCurrentTime("key1");
        TimeUnit.SECONDS.sleep(1);
        String t2 = redisDemo.getCurrentTime("key1");
        TimeUnit.SECONDS.sleep(1);
        String t3 = redisDemo.getCurrentTime("key3");
        Assert.assertNotEquals(t1, t3);
        Assert.assertEquals(t1, t2);
        redisDemo.removeCurrentTime("key1");
        String t4 = redisDemo.getCurrentTime("key1");
        Assert.assertNotEquals(t1, t4);
    }

    @Test
    public void testHello() {
        Assert.assertEquals("world", redisDemo.hello());
    }
}
