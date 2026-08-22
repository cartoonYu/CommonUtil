package org.redis.demo;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author cartoon.yu
 * @since 2026/08/22 17:26
 */
@Service
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}