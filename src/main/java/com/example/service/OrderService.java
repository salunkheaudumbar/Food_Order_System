package com.example.service;



import org.springframework.data.domain.Page;

import com.example.dto.OrderRequestDTO;
import com.example.dto.OrderResponseDTO;
import com.example.dto.OrderStatusDTO;
import com.example.enums.OrderStatus;

public interface OrderService {
    OrderResponseDTO placeOrder(OrderRequestDTO dto);
    Page<OrderResponseDTO> getOrders(int page, int size);
    OrderStatusDTO getOrderStatus(Long orderId);
    void updateOrderStatus(Long orderId, OrderStatus status);
}
