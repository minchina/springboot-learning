package org.ncmao.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SmsService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void validate(String phoneNumber) {
        String key = "sms_limit".concat(phoneNumber);
        Long count = redisTemplate.opsForValue().increment(key, 1);
        if (count == 1) {
            redisTemplate.expire(key, 60, TimeUnit.SECONDS);
            System.out.println("sms had already sent");
        } else {
            System.out.println("can only send one time sms in 60 seconds");
        }
    }
}
