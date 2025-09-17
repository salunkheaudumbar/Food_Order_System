package com.example.util;

import com.example.dto.OrderResponseDTO;
import com.example.entity.OrderEntity;

public class MapperUtil {
    public static OrderResponseDTO mapToResponseDTO(OrderEntity entity) {
        return new OrderResponseDTO(
                entity.getId(),
                entity.getCustomerName(),
                entity.getItems(),
                entity.getTotalAmount(),
                entity.getOrderTime(),
                entity.getStatus()
        );
    }
}
