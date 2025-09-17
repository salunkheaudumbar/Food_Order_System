package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.OrderRequestDTO;
import com.example.dto.OrderResponseDTO;
import com.example.dto.OrderStatusDTO;
import com.example.entity.OrderEntity;
import com.example.enums.OrderStatus;
import com.example.exception.ResourceNotFoundException;
import com.example.repositorty.OrderRepository;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    private static final String ORDER_QUEUE = "order-queue";

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    @Transactional
    public OrderResponseDTO placeOrder(OrderRequestDTO dto) {
    	OrderEntity order = new OrderEntity();
    	order.setCustomerName(dto.getCustomerName());
    	order.setItems(dto.getItems());
    	order.setTotalAmount(dto.getTotalAmount());
    	order.setOrderTime(LocalDateTime.now());
    	order.setStatus(OrderStatus.PENDING);


        OrderEntity savedOrder = orderRepository.save(order);

        redisTemplate.opsForList().leftPush(ORDER_QUEUE, savedOrder.getId());

        return new OrderResponseDTO(
                savedOrder.getId(),
                savedOrder.getCustomerName(),
                savedOrder.getItems(),
                savedOrder.getTotalAmount(),
                savedOrder.getOrderTime(),
                savedOrder.getStatus()
        );
    }

    @Override
    public Page<OrderResponseDTO> getOrders(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<OrderEntity> orders = orderRepository.findAll(pageable);

        return orders.map(o -> new OrderResponseDTO(
                o.getId(),
                o.getCustomerName(),
                o.getItems(),
                o.getTotalAmount(),
                o.getOrderTime(),
                o.getStatus()
        ));
    }

    @Override
    public OrderStatusDTO getOrderStatus(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found: " + orderId));

        return new OrderStatusDTO(order.getId(), order.getStatus());
    }

    @Override
    @Transactional
    public void updateOrderStatus(Long orderId, OrderStatus status) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found: " + orderId));

        order.setStatus(status);
        orderRepository.save(order);
    }
}
