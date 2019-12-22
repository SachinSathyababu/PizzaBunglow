package com.mytectra.springboot.PizzaBunglow.web.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.mytectra.springboot.PizzaBunglow.Store.PizzaStore;
import com.mytectra.springboot.PizzaBunglow.model.Pizza;
import com.mytectra.springboot.PizzaBunglow.web.controllers.model.RequestScopeBean;

@ExtendWith({SpringExtension.class})
@WebMvcTest(controllers = {PizzaController.class})
public class PizzaControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PizzaStore pizzaStore;
	
	@MockBean
	private RequestScopeBean bean;
	
	
	
	@Test
	public void testGetPizzasJson() throws Exception {
		

		Pizza pizza= new Pizza();
		pizza.setId(1);
		pizza.setName("Panner Pizza");
		pizza.setCost(300);
		pizza.setDescription("topped with panner");
		
		Pizza pizza1= new Pizza();
		pizza1.setId(2);
		pizza1.setName("Chicken Pizza");
		pizza1.setCost(450);
		pizza1.setDescription("topped with chicken");
		
		List<Pizza> pizzaList= new ArrayList<>();
		pizzaList.add(pizza);
		pizzaList.add(pizza1);
		Mockito.when(pizzaStore.getAllPizzas()).thenReturn(pizzaList);
		
		mvc.perform(MockMvcRequestBuilders.get(URI.create("/pizzas")))
		.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].pizza_id").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$[1].pizza_id").value(2));

		
	}

	
	@Test
	public void testGetPizzasXML() throws Exception {
		

		Pizza pizza= new Pizza();
		pizza.setId(1);
		pizza.setName("Panner Pizza");
		pizza.setCost(300);
		pizza.setDescription("topped with panner");
		
		Pizza pizza1= new Pizza();
		pizza1.setId(2);
		pizza1.setName("Chicken Pizza");
		pizza1.setCost(450);
		pizza1.setDescription("topped with chicken");
		
		List<Pizza> pizzaList= new ArrayList<>();
		pizzaList.add(pizza);
		pizzaList.add(pizza1);
		Mockito.when(pizzaStore.getAllPizzas()).thenReturn(pizzaList);
		
		mvc.perform(MockMvcRequestBuilders.get(URI.create("/pizzas")).accept(MediaType.APPLICATION_XML_VALUE))
		.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_XML_VALUE))
		.andExpect(MockMvcResultMatchers.xpath("/List/item[1]/pizza_id").string("1"));

		
	}
	

	@Test
	public void testGetPizzasSearch() throws Exception {
		

		Pizza pizza= new Pizza();
		pizza.setId(1);
		pizza.setName("Panner Pizza");
		pizza.setCost(300);
		pizza.setDescription("topped with panner");
		
		Pizza pizza1= new Pizza();
		pizza1.setId(2);
		pizza1.setName("Chicken Pizza");
		pizza1.setCost(450);
		pizza1.setDescription("topped with chicken");
		
		List<Pizza> pizzaList= new ArrayList<>();
		pizzaList.add(pizza);
		pizzaList.add(pizza1);
		Mockito.when(pizzaStore.getPizzaByName(pizza.getName())).thenReturn(pizza);
		
		mvc.perform(MockMvcRequestBuilders.get(URI.create("/pizzas/search")).param("name", pizza.getName()))
		.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.jsonPath("$.pizza_id").value(pizza.getId()));

		
	}
	
	@Test
	public void testGetPizzasInsert() throws Exception {
		
		
		String jsonPizza = "{"
				 + "\"pizza_id\"  : 1,"
				+ " \"name\": \"Panner Pizza Hot\","
				+ "\"description\": \"topped with panner spicy\","
				+ " \"cost\": 300"
				+ "}";

		
		mvc.perform(MockMvcRequestBuilders.post(URI.create("/pizzas")).content(jsonPizza).contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("SUCCESS"));
		
		Mockito.verify(pizzaStore, Mockito.times(1)).addPizza(Mockito.any(Pizza.class));

		
	}

}
