package com.example.dto;

import com.example.enums.OrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {
    private Long id;
    private String customerName;
    private String items;
    private BigDecimal totalAmount;
    private LocalDateTime orderTime;
    private OrderStatus status;
	public OrderResponseDTO() {
		super();
	}
	public OrderResponseDTO(Long id, String customerName, String items, BigDecimal totalAmount, LocalDateTime orderTime,
			OrderStatus status) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.items = items;
		this.totalAmount = totalAmount;
		this.orderTime = orderTime;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
