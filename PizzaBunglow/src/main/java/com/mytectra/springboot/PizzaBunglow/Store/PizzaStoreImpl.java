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
		
		if(pizza!=null /*&& 
				pizza.getName()!=null && !pizza.getName().trim().isEmpty() &&
				pizza.getId()!=0 && pizza.getCost()!=0 && 
				pizza.getDescription()!=null && !pizza.getDescription().trim().isEmpty()*/){
		pizzas.add(pizza);
	}
	}
	
	@Override
	public List<Pizza> getAllPizzas() {
		return new ArrayList<Pizza> (pizzas);
	}

	@Override
	public Pizza getPizzaByName(String pizzaName) {
		
		if(pizzaName!=null && !pizzaName.trim().isEmpty()) {
		for(Pizza pizza : pizzas) {
			if(pizza.getName().equalsIgnoreCase(pizzaName)) {
				return pizza;
			}
		}
		}
		return null;
	}

	
}
