package com.example.demo.service;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class RateLimitService {

    @Value("${app.rate-limit.requests-per-minute}")
    private int requestsPerMinute;
    
    private final Map<String, AtomicInteger> userRequests = new ConcurrentHashMap<>();

    public boolean allowRequest(String userId) {
        AtomicInteger count = userRequests.computeIfAbsent(userId, k -> new AtomicInteger(0));
        
        int current = count.incrementAndGet();
        if (current > requestsPerMinute) {
            count.decrementAndGet(); // Rollback the count
            return false; // Rate limit exceeded
        }
        return true; // Request allowed
    }

    @Scheduled(fixedRate = 60000) // Reset every minute
    public void resetCounters() {
        userRequests.clear();
    }

    public int getRequestsPerMinute() {
        return requestsPerMinute;
    }


}
