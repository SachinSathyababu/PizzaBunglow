package com.mytectra.springboot.PizzaBunglow.Store;

import java.util.List;

import com.mytectra.springboot.PizzaBunglow.model.Pizza;

public interface PizzaStore {
	
	public void addPizza(Pizza pizza);
	
	public List<Pizza> getAllPizzas();
	
	public Pizza getPizzaByName(String pizzaName);
	
	public Pizza getPizzaById(int id);
	
	public void updatePizza(Pizza pizza);
	
	public void deletePizza(int id);

}
