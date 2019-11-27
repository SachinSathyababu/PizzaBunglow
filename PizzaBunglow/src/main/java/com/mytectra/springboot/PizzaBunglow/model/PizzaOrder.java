package com.mytectra.springboot.PizzaBunglow.model;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {
	
	private int orderId;
	
	private List<OrderItem> orderItem = new ArrayList<OrderItem>();
	
	public enum Status { CANCELED, PROCESSING, DELIVERED };
	
	private Status status;
	
	private String message;
	
	
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
