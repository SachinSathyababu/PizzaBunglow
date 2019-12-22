package com.mytectra.springboot.PizzaBunglow.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import com.mytectra.springboot.PizzaBunglow.web.controllers.model.Error;
import com.mytectra.springboot.PizzaBunglow.web.controllers.model.RequestScopeBean;
import com.mytectra.springboot.PizzaBunglow.web.controllers.model.ResponseWrapper;
import com.mytectra.springboot.PizzaBunglow.web.controllers.model.ResponseWrapper.Status;
import com.mytectra.springboot.PizzaBunglow.web.validators.CustomValidator;

//@Controller
@Validated
@RestController
@RequestMapping("/pizzas")
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
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public List<Pizza> getPizzas(){
		return pizzaStore.getAllPizzas();
	}
	
	@GetMapping("/search")
	public Pizza getPizza(@RequestParam(required = true , name = "name") String name){
		Pizza pizza= pizzaStore.getPizzaByName(name);
		return pizza;
	
	}
	
	@PostMapping( consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE} )
	public ResponseWrapper<?> addPizza(@Valid @RequestBody Pizza pizza ) {
		pizzaStore.addPizza(pizza);
		return new ResponseWrapper<String>("Succesfully Created", Status.SUCCESS);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseWrapper<?>  handleBindingEx(MethodArgumentNotValidException obj) {
		BindingResult results = obj.getBindingResult();
		List<FieldError> errors = results.getFieldErrors();
		List<Error> errs = new ArrayList<Error>();
		for(FieldError err : errors) {
			String errMsg = String.format("%s Field is failed deu to %s , value given is %s", err.getField() , err.getDefaultMessage() , err.getRejectedValue());
			Error errS = new Error(err.getField(),errMsg);
			errs.add(errS);
		}
		
		return  new ResponseWrapper<List<Error> >(errs, Status.FAILURE);
	}
	
	@PostMapping( headers = "List")
	public String addPizzaList(@Valid @RequestBody List<Pizza> pizzaList ) {
		pizzaStore.addPizzaList(pizzaList);
		return "SUCCESS";
	}

	
	//Path Variable
	@GetMapping("/{id}")
	public Pizza getPizza(@PathVariable("id") Integer id , @RequestHeader(name = "client" ,required = false) String client) {
		System.out.println("THis is Header Param" + client);
		return pizzaStore.getPizzaById(id);
	}
	
	@PutMapping("/{id}")
	public String updatePizza(@PathVariable("id") Integer id ,@RequestBody Pizza pizza) {
		pizza.setId(id);
		pizzaStore.updatePizza(pizza);
		return "SUCCESS";
	}
	
	@DeleteMapping("/{id}")
	public String deletePizza(@PathVariable("id") Integer id) {
		
		pizzaStore.deletePizza(id);
		return "SUCCESS";
	}
	

}
