package com.mytectra.springboot.PizzaBunglow.Store;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.mytectra.springboot.PizzaBunglow.model.Pizza;

public interface PizzaStore {
	
	public void addPizza(Pizza pizza);
	
	public void addPizzaList( @NotNull List<Pizza> pizzaList) ;
	
	public List<Pizza> getAllPizzas();
	
	public Pizza getPizzaByName(String pizzaName);
	
	public Pizza getPizzaById(int id);
	
	public void updatePizza(Pizza pizza);
	
	public void deletePizza(int id);

}
