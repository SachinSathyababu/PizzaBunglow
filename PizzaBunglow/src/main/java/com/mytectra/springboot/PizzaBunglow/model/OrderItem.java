package com.mytectra.springboot.PizzaBunglow.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class OrderItem {
	
	
	@NotEmpty(message = "Pizza Requests Cannot be empty or null")	
	@NotBlank(message ="Pizza Requests Cannot be white spaces")
	private Pizza pizza;
	 
	@Positive(message = "OrderItem count cannot be negative number")
	private int count;

	@NotEmpty(message = "AddOns Name Cannot be empty or null")	
	@NotBlank(message ="Addons Name Cannot be white spaces")
	private AddOns addOns;
	
	public OrderItem() {
	}
	
	public OrderItem(AddOns addOns,int count) {
		super();
		this.count = count;
		this.addOns = addOns;
	}

	public OrderItem(Pizza pizza, int count) {
		super();
		this.pizza = pizza;
		this.count = count;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public AddOns getAddOns() {
		return addOns;
	}

	public void setAddOns(AddOns addOns) {
		this.addOns = addOns;
	}
	
	

}
