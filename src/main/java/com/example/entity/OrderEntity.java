package com.example.entity;

import com.example.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false, length = 1000)
    private String items;

    @Column(nullable = false)
    private BigDecimal totalAmount;

    @Column(nullable = false)
    private LocalDateTime orderTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

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

	@Override
	public int hashCode() {
		return Objects.hash(customerName, id, items, orderTime, status, totalAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderEntity other = (OrderEntity) obj;
		return Objects.equals(customerName, other.customerName) && Objects.equals(id, other.id)
				&& Objects.equals(items, other.items) && Objects.equals(orderTime, other.orderTime)
				&& status == other.status && Objects.equals(totalAmount, other.totalAmount);
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", customerName=" + customerName + ", items=" + items + ", totalAmount="
				+ totalAmount + ", orderTime=" + orderTime + ", status=" + status + "]";
	}

	public OrderEntity(Long id, String customerName, String items, BigDecimal totalAmount, LocalDateTime orderTime,
			OrderStatus status) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.items = items;
		this.totalAmount = totalAmount;
		this.orderTime = orderTime;
		this.status = status;
	}

	public OrderEntity() {
		super();
	}

	
}
