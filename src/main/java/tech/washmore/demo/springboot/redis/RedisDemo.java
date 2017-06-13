package tech.washmore.demo.springboot.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Washmore
 * @version V1.0
 * @summary redis缓存demo
 * @Copyright (c) 2017, www.washmore.tech
 * @since 2017/6/13
 */
@Component
public class RedisDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisDemo.class);
    @Resource
    private RedisTemplate redisTemplate;

    @Cacheable(value = RedisCacheConfig.CacheNames.WASHMORE_CACHE_15MINS, key = "'washmore:getCurrentTime'+#testKey")
    public String getCurrentTime(String testKey) {
        long current = System.currentTimeMillis();
        LOGGER.info("当前时间戳:{}", current);
        return String.valueOf(current);
    }

    @CacheEvict(value = RedisCacheConfig.CacheNames.WASHMORE_CACHE_15MINS, key = "'washmore:getCurrentTime'+#testKey")
    public void removeCurrentTime(String testKey) {
        LOGGER.info("销毁缓存:{}", testKey);
    }

    public String hello() {
        redisTemplate.opsForValue().set("hello", "world");
        LOGGER.info(redisTemplate.opsForValue().get("hello").toString());
        return redisTemplate.opsForValue().get("hello").toString();
    }
}
