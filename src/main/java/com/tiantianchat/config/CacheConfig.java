package com.tiantianchat.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author Wangyl
 * @date 2019/7/22
 */
@EnableCaching
@Configuration
public class CacheConfig {

//    @Bean
//    public CacheManager cacheManager() {
//        return new CaffeineCacheManager();
//    }
}
