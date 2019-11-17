package com.mytectra.springboot.PizzaBunglow.model;

import java.util.List;

public class PizzaRequests {
	
	private List<PizzaRequest> pizzaRequests;
	
	public PizzaRequests() {}

	public PizzaRequests(List<PizzaRequest> pizzaRequests) {
		super();
		this.pizzaRequests = pizzaRequests;
	}

	public List<PizzaRequest> getPizzaRequests() {
		return pizzaRequests;
	}

	public void setPizzaRequests(List<PizzaRequest> pizzaRequests) {
		this.pizzaRequests = pizzaRequests;
	}
	
	

}
