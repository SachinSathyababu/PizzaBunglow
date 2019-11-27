package com.mytectra.springboot.PizzaBunglow.model;

public class OrderItem {
	
	private Pizza pizza;
	 
	private int count;

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
