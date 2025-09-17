package com.example.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.enums.OrderStatus;
import com.example.repositorty.OrderRepository;

@Component
public class RedisOrderQueueConsumer {
    private static final String ORDER_QUEUE = "order-queue";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Scheduled(fixedDelay = 5000)
    public void consumeOrder() {
        Long orderId = (Long) redisTemplate.opsForList().rightPop(ORDER_QUEUE);
        if (orderId != null) {
            orderRepository.findById(orderId).ifPresent(order -> {
                order.setStatus(OrderStatus.PROCESSED);
                orderRepository.save(order);
                System.out.println("Processed Order ID: " + orderId);
            });
        }
    }
}
