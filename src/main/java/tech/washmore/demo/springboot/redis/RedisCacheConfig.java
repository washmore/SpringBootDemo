package tech.washmore.demo.springboot.redis;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Washmore
 * @version V1.0
 * @summary Redis配置
 * @Copyright (c) 2017, www.washmore.tech
 * @since 2017/6/13
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
    @Configuration
    static class LocalCacheConfig implements InitializingBean {
        @Autowired
        ApplicationContext context;

        /*
         * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
         */
        @Override
        public void afterPropertiesSet() throws Exception {
            try {
                RedisCacheManager cacheManager = this.context.getBean(RedisCacheManager.class);
                Map<String, Long> expires = new HashMap<String, Long>();
                expires.put(RedisCacheConfig.CacheNames.WASHMORE_CACHE_15MINS, 15L * 60);
                expires.put(RedisCacheConfig.CacheNames.WASHMORE_CACHE_30MINS, 30L * 60);
                expires.put(RedisCacheConfig.CacheNames.WASHMORE_CACHE_60MINS, 60L * 60);
                expires.put(RedisCacheConfig.CacheNames.WASHMORE_CACHE_3HOURS, 3 * 60L * 60);
                expires.put(RedisCacheConfig.CacheNames.WASHMORE_CACHE_4HOURS, 4 * 60L * 60);
                expires.put(RedisCacheConfig.CacheNames.WASHMORE_CACHE_ETERNAL, 0L);
                cacheManager.setExpires(expires);
            } catch (NoSuchBeanDefinitionException e) {
                throw new Exception("=======>>>缓存启用失败！！！");
            }
        }
    }

    public interface CacheNames {
        /**
         * 15分钟缓存组
         */
        String WASHMORE_CACHE_15MINS = "washmore_cache_15m";
        /**
         * 30分钟缓存组
         */
        String WASHMORE_CACHE_30MINS = "washmore_cache_30m";
        /**
         * 60分钟缓存组
         */
        String WASHMORE_CACHE_60MINS = "washmore_cache_60m";
        /**
         * 3小时缓存组
         */
        String WASHMORE_CACHE_3HOURS = "washmore_cache_3h";
        /**
         * 4小时缓存组
         */
        String WASHMORE_CACHE_4HOURS = "washmore_cache_4h";
        /**
         * 永久缓存组
         */
        String WASHMORE_CACHE_ETERNAL = "washmore_cache_eternal";
    }

    /**
     * 异常处理器,当使用注解形式缓存的时候,如果缓存服务器出问题,我们希望对服务降级到数据库,而非直接中断正常业务逻辑的话,需要在此复写该方法自行提供异常处理器实现,springboot自动装配的异常处理器会直接抛出;
     *
     * @return
     */
    @Override
    public CacheErrorHandler errorHandler() {
        return new WashmoreCacheErrorHandler();
    }


}
