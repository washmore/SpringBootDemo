package tech.washmore.demo.springboot.redis;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

/**
 * @author Washmore
 * @version V1.0
 * @summary 在各个方法中书写通用处理代码
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2017/7/12
 */
public class WashmoreCacheErrorHandler implements CacheErrorHandler {
    @Override
    public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {

    }

    @Override
    public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {

    }

    @Override
    public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {

    }

    @Override
    public void handleCacheClearError(RuntimeException exception, Cache cache) {

    }
}
