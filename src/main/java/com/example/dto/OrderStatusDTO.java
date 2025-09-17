package com.example.dto;

import com.example.enums.OrderStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatusDTO {
    private Long orderId;
    private OrderStatus status;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public OrderStatusDTO(Long orderId, OrderStatus status) {
		super();
		this.orderId = orderId;
		this.status = status;
	}
	public OrderStatusDTO() {
		super();
	}
}
