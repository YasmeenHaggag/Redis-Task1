package com.example.Task.service;

import com.example.Task.entity.RateLimit;
import com.example.Task.repository.RateLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    RedisTemplate<String, Integer> redisTemplate;

    @Autowired
    RateLimitService rateLimitService;

    Long counter;
    public boolean checkLimit(int userId) {
        RateLimit userLimit = rateLimitService.findUserLimitById(userId);
        ValueOperations<String, Integer> operations = redisTemplate.opsForValue();

        String key = "Limit" + userId;
         counter = operations.increment(key);
        if (counter == 1) {
            redisTemplate.expire(key, userLimit.getDuration(), TimeUnit.SECONDS);
        }
        if (counter > userLimit.getMaxRequests()){
            logUpnormalBehavior(userLimit);
            return true;
        }
        return false;
    }


    public void logUpnormalBehavior(RateLimit userLimit) {
            String logMessage = String.format(
                    "User with ID %d exceeded limit [%d requests ] : allowed: %d in %d seconds %n",
                    userLimit.getUserId(),counter,userLimit.getMaxRequests(), userLimit.getDuration()
                    );

            try (PrintWriter out = new PrintWriter(new FileWriter("Logs.txt", true))) {
                out.print(logMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




