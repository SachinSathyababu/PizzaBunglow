package com.mytectra.springboot.PizzaBunglow.Store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytectra.springboot.PizzaBunglow.model.Pizza;
import com.mytectra.springboot.PizzaBunglow.web.controllers.model.RequestScopeBean;

@Component
public class PizzaStoreImpl implements PizzaStore{
	
	private List<Pizza> pizzas= new ArrayList<Pizza>();
	
	@Autowired
	private RequestScopeBean bean;

	@Override
	public void addPizza(Pizza pizza) {
		//System.out.println("for " + bean.getClient());
		if(pizza!=null && 
				pizza.getName()!=null && !pizza.getName().trim().isEmpty() &&
				pizza.getId()!=0 && pizza.getCost()!=0 && 
				pizza.getDescription()!=null && !pizza.getDescription().trim().isEmpty()){
		pizzas.add(pizza);
	}
	}
	
	@Override
	public List<Pizza> getAllPizzas() {
		//System.out.println("for " + bean.getClient());

		return new ArrayList<Pizza> (pizzas);
	}

	@Override
	public Pizza getPizzaByName(String pizzaName) {
		//System.out.println("for " + bean.getClient());

		if(pizzaName!=null && !pizzaName.trim().isEmpty()) {
		for(Pizza pizza : pizzas) {
			if(pizza.getName().equalsIgnoreCase(pizzaName)) {
				return pizza;
			}
		}
		}
		return null;
	}

	@Override
	public Pizza getPizzaById(int id) {
		// TODO Auto-generated method stub
		//System.out.println("for " + bean.getClient());

		if(id>0) {
			for(Pizza pizza : pizzas) {
				if(pizza.getId()==id) {
					return pizza;
				}
			}
			}
			return null;
	}

	@Override
	public void updatePizza(Pizza pizza) {
		// TODO Auto-generated method stub
		if(pizza!=null /*&& 
				pizza.getName()!=null && !pizza.getName().trim().isEmpty() &&
				pizza.getId()!=0 && pizza.getCost()!=0 && 
				pizza.getDescription()!=null && !pizza.getDescription().trim().isEmpty()*/){
		Pizza pizza1= getPizzaById(pizza.getId());
		if(pizza1!=null) {
			pizzas.remove(pizza1);
			pizzas.add(pizza);
		}
	}
			
	}

	@Override
	public void deletePizza(int id) {
		// TODO Auto-generated method stub
		if(id>0 /*&& 
				pizza.getName()!=null && !pizza.getName().trim().isEmpty() &&
				pizza.getId()!=0 && pizza.getCost()!=0 && 
				pizza.getDescription()!=null && !pizza.getDescription().trim().isEmpty()*/){
		Pizza pizza1= getPizzaById(id);
		if(pizza1!=null) {
			pizzas.remove(pizza1);
			
		}
	}
			
	}
}
