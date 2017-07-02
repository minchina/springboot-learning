package org.ncmao.service;


import org.ncmao.domain.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RedisTokenManager {

    @Autowired
    private RedisTemplate redisTemplate;

    public TokenModel createToken(Long userId){
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel();
        model.setToken(token);
        model.setUserId(userId);
        redisTemplate.boundValueOps(token).set(userId);
        return model;
    }

}
