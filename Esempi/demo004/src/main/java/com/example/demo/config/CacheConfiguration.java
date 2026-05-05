package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.managers.ICacheManager;
import com.example.demo.managers.InMemoryCacheManager;
import com.example.demo.managers.RedisCacheManager;

@Configuration
public class CacheConfiguration {
    
    // Usare Redis cache se il Redis client è nel casspath
    @Bean
    @ConditionalOnClass(name = "org.springframework.data.redis.core.RedisTemplate")
    @ConditionalOnProperty("cache.redis.enabled")
    @ConditionalOnMissingBean(ICacheManager.class) // Se non è già definito un bean di tipo ICacheManager
    public ICacheManager redisCacheManager() {
        return new RedisCacheManager();
    }

    // Usare in-memory cache se Redis non disponibile
    @Bean
    @ConditionalOnMissingBean(name = "org.springframework.data.redis.core.RedisTemplate")
    public ICacheManager inMemoryCacheManager() {
        return new InMemoryCacheManager();
    }



}
