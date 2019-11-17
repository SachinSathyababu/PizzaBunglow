package com.mytectra.springboot.PizzaBunglow.Store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mytectra.springboot.PizzaBunglow.model.Pizza;

@Component
public class PizzaStoreImpl implements PizzaStore{
	
	private List<Pizza> pizzas= new ArrayList<Pizza>();

	@Override
	public void addPizza(Pizza pizza) {
		pizzas.add(pizza);
	}

	@Override
	public List<Pizza> getAllPizzas() {
		return new ArrayList<> (pizzas);
	}

	@Override
	public Pizza getPizzaByName(String pizzaName) {
		for(Pizza pizza : pizzas) {
			if(pizza.getName().equalsIgnoreCase(pizzaName)) {
				return pizza;
			}
		}
		return null;
	}

	
}
