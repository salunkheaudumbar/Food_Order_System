package com.example.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
    private String customerName;
    private String items;
    private BigDecimal totalAmount;
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
	public OrderRequestDTO(String customerName, String items, BigDecimal totalAmount) {
		super();
		this.customerName = customerName;
		this.items = items;
		this.totalAmount = totalAmount;
	}
	public OrderRequestDTO() {
		super();
	}
    
}
