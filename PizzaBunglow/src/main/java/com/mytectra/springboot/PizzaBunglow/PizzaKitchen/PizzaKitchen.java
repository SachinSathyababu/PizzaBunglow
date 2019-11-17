package com.mytectra.springboot.PizzaBunglow.PizzaKitchen;

import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequests;

public interface PizzaKitchen {
	
	public PizzaOrder Order(PizzaRequests pizzaRequest) throws Exception;

}
