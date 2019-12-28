package com.mytectra.springboot.PizzaBunglow.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PizzaOrder {
	
	@Positive(message="INVALID ORDER ID")
	private int orderId;
	
	@NotNull
	@Size(min=1, message="No order items")
	private List<OrderItem> orderItem = new ArrayList<OrderItem>();
	
	
	public enum Status { CANCELED, PROCESSING, DELIVERED };
	
	@NotEmpty(message = "Order Status Cannot be empty or null")	
	@NotBlank(message ="Order Status Cannot be white spaces")
	private Status status;
	
	@NotEmpty(message = "Order Message Cannot be empty or null")
	@Size(min = 3 , max = 50 , message = "Size to be between 3 - 50 length")
	@NotBlank(message ="Order Message Cannot be white spaces")
	private String message;
	
	@Pattern(regexp = "[0-9]{10}" , message = "invalid phone number")
	private String phoneNumber;
	
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	@FutureOrPresent(message="Order Date is past date")
	private Date orderDate;
	
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	
	
	

}
