package com.mytectra.springboot.PizzaBunglow.Baker;

import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequests;

public interface Baker {
	
	public PizzaOrder bake(PizzaRequests pizzaRequests) throws PizzaBakeException;

}
