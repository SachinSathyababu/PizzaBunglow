package com.mytectra.springboot.PizzaBunglow.Store;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mytectra.springboot.PizzaBunglow.model.AddOns;
import com.mytectra.springboot.PizzaBunglow.model.Pizza;

public class PizzaStoreImplTest{
	
	private PizzaStoreImpl store;
	
	@BeforeEach
	public void init() {
	 store= new PizzaStoreImpl();
	}
	
	@Test
	public void test_AddingAllTypesOfPizza() {
		
		Pizza pizza= null;
		Pizza pizza1= new Pizza();
		Pizza pizza2= new Pizza(1, "Chicken Pizza", "Chicken Pizza with Spicy", 350);
		Pizza pizza3= new Pizza(0, "Chicken Pizza", "Chicken Pizza with Spicy", 350);
		Pizza pizza4= new Pizza(1, null, "Chicken Pizza with Spicy", 350);
		Pizza pizza5= new Pizza(1, "   ", "Chicken Pizza with Spicy", 350);
		Pizza pizza6= new Pizza(1, "Chicken Pizza", null, 350);
		Pizza pizza7= new Pizza(1, "Chicken Pizza", "   ", 350);
		Pizza pizza8= new Pizza(1, "Chicken Pizza", "Chicken Pizza with Spicy", 0);
		
		
		
		store.addPizza(pizza);
		store.addPizza(pizza1);
		store.addPizza(pizza2);
		store.addPizza(pizza3);
		store.addPizza(pizza4);
		store.addPizza(pizza5);
		store.addPizza(pizza6);
		store.addPizza(pizza7);
		store.addPizza(pizza8);
		
		assertEquals(1, store.getAllPizzas().size());
	}
	
	@Test
	public void test_getNullPizza() {
		
		assertEquals(null, store.getPizzaByName(null));
	}
	
	@Test
	public void test_getEmptyPizzaName() {
		
		assertEquals(null, store.getPizzaByName("   "));
	}

	
	@Test
	public void test_getPizzaByPizzaName() {
		
		
		Pizza pizza2= new Pizza(1, "Chicken Pizza", "Chicken Pizza with Spicy", 350);
		
		
		store.addPizza(pizza2);
		
		
		assertEquals(pizza2, store.getPizzaByName("Chicken Pizza"));
	}

	@Test
	public void test_getPizzaByPizzaNameFromEmptyList() {
		
		assertEquals(null, store.getPizzaByName("Chicken Pizza"));
	}
	
	
}
