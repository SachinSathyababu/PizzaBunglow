package com.mytectra.springboot.PizzaBunglow.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mytectra.springboot.PizzaBunglow.Store.PizzaStore;
import com.mytectra.springboot.PizzaBunglow.model.Pizza;
import com.mytectra.springboot.PizzaBunglow.web.controllers.model.RequestScopeBean;

//@Controller
@RestController
public class PizzaController {

	@Autowired
	private PizzaStore pizzaStore;
	
	@Autowired
	private RequestScopeBean bean;
	
	//@RequestMapping(path = "/pizzas" , method = RequestMethod.GET)
	/*
	 * Using HttpServlet Request 
	 * @GetMapping("/pizzas")
	public List<Pizza> getPizzas(HttpServletRequest request){
		System.out.println(request.getHeader("client"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getRequestURL());
		System.out.print(request.getMethod());
 bean.setClient(request.getHeader("client"));

		
		return pizzaStore.getAllPizzas();
	
	}*/
	
	@GetMapping("/pizzas")
	public List<Pizza> getPizzas(){
		
		return pizzaStore.getAllPizzas();
	
	}
	
	@GetMapping("/pizzas/search")
	public Pizza getPizza(@RequestParam(required = true , name = "name") String name){
		Pizza pizza= pizzaStore.getPizzaByName(name);
		return pizza;
	
	}
	
	@PostMapping("/pizzas")
	public String addPizza(@Valid @RequestBody Pizza pizza) {

		
		pizzaStore.addPizza(pizza);
		return "SUCCESS";
	}

	
	//Path Variable
	@GetMapping("/pizzas/{id}")
	public Pizza getPizza(@PathVariable("id") Integer id , @RequestHeader(name = "client" ,required = false) String client) {
		System.out.println("THis is Header Param" + client);
		return pizzaStore.getPizzaById(id);
	}
	
	@PutMapping("/pizzas/{id}")
	public String updatePizza(@PathVariable("id") Integer id ,@RequestBody Pizza pizza) {
		pizza.setId(id);
		pizzaStore.updatePizza(pizza);
		return "SUCCESS";
	}
	
	@DeleteMapping("/pizzas/{id}")
	public String deletePizza(@PathVariable("id") Integer id) {
		
		pizzaStore.deletePizza(id);
		return "SUCCESS";
	}
	

}
