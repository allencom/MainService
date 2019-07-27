package com.producer.producer.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisService {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    public RedisService() {
    }

    public boolean exists(final String key) {
        return this.redisTemplate.hasKey(key);
    }

    public boolean write(final String key, Object value) {
        boolean result = false;

        try {
            ValueOperations<Object, Object> operations = this.redisTemplate.opsForValue();
            operations.set(key, JSON.toJSONString(value));
            result = true;
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return result;
    }

    public boolean write(final String key, Object value, long timeout) {
        boolean result = false;

        try {
            ValueOperations<Object, Object> operations = this.redisTemplate.opsForValue();
            operations.set(key, JSON.toJSONString(value));
            this.redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
            result = true;
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return result;
    }

    public <T> T read(final String key, Class<T> clazz) {
        ValueOperations<Object, Object> operations = this.redisTemplate.opsForValue();
        Object value = operations.get(key);
        return value != null ? JSON.parseObject(String.valueOf(value), clazz) : null;
    }

    public <T> List<T> readList(final String key, Class<T> clazz) {
        ValueOperations<Object, Object> operations = this.redisTemplate.opsForValue();
        Object value = operations.get(key);
        return value != null ? JSON.parseArray(String.valueOf(value), clazz) : null;
    }

    public boolean remove(final String key) {
        return this.exists(key) ? this.redisTemplate.delete(key) : true;
    }
}
