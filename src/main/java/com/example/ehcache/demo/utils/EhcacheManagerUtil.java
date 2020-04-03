package com.example.ehcache.demo.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

@Component
public class EhcacheManagerUtil {

    private static CacheManager cacheManager;

    private EhcacheManagerUtil() {
        try {
            CachingProvider provider = Caching.getCachingProvider();
            cacheManager = provider.getCacheManager(
                    new ClassPathResource("ehcache.xml").getURI(),
                    getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // cache를 이름별로 clear하는 메서드
    public void clearCache(String cacheName) {
        try {
            cacheManager.getCache(cacheName).clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 전체 cache를 clear하는 메서드
    public void clearCacheAll() {
        Iterable<String> cacheNames = cacheManager.getCacheNames();
        try {
            for (String cacheName : cacheNames) {
                cacheManager.getCache(cacheName).clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
