package com.mytectra.springboot.PizzaBunglow.model;

public class OrderItem {
	
	private Pizza pizza;
	 
	private int count;

	
	
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
	
	

}
