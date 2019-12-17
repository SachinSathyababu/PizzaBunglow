package com.mytectra.springboot.PizzaBunglow.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PizzaOrder {
	
	@Positive(message="INVALID ORDER ID")
	private int orderId;
	
	@NotNull
	@Size(min=1, message="No order items")
	private List<OrderItem> orderItem = new ArrayList<OrderItem>();
	
	
	public enum Status { CANCELED, PROCESSING, DELIVERED };
	
	
	private Status status;
	
	
	private String message;
	
	@Pattern(regexp = "[0-9]{10}" , message = "invalid phone number")
	private String phoneNumber;
	
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private Price price;
	
	public PizzaOrder() {}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public void addOrder(OrderItem order) {
		orderItem.add(order);
	}

	
	
	

}
