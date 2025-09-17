package com.example.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisOrderQueueProducer {
    private static final String ORDER_QUEUE = "order-queue";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void sendOrder(Long orderId) {
        redisTemplate.opsForList().leftPush(ORDER_QUEUE, orderId);
    }
}
