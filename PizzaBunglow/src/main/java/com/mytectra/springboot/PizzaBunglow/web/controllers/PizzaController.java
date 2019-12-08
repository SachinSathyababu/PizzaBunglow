package com.mytectra.springboot.PizzaBunglow.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mytectra.springboot.PizzaBunglow.Store.PizzaStore;
import com.mytectra.springboot.PizzaBunglow.model.Pizza;

//@Controller
@RestController
public class PizzaController {

	@Autowired
	private PizzaStore pizzaStore;
	
	//@RequestMapping(path = "/pizzas" , method = RequestMethod.GET)
	@GetMapping("/pizzas")
	public List<Pizza> getPizzas(@RequestParam(required = false , name = "name") String name){
		return pizzaStore.getAllPizzas();
	
	}
	
	@GetMapping("/pizzas/search")
	public Pizza getPizza(@RequestParam(required = true , name = "name") String name){
		Pizza pizza= pizzaStore.getPizzaByName(name);
		return pizza;
	
	}
	
	@PostMapping("/pizzas")
	public String addPizza(@RequestBody Pizza pizza) {
		pizzaStore.addPizza(pizza);
		return "SUCCESS";
	}

}
