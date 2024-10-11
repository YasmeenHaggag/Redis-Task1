package com.example.Task.service;

import com.example.Task.entity.RateLimit;
import com.example.Task.repository.RateLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateLimitService {
    @Autowired
    RateLimitRepository rateLimitRepository;
    public RateLimit findUserLimitById(int userId){
        return rateLimitRepository.findUserLimitById(userId);
    }

}
