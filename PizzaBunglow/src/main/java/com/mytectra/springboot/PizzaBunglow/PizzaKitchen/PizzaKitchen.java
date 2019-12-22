package com.mytectra.springboot.PizzaBunglow.PizzaKitchen;

import java.util.Date;
import java.util.List;

import com.mytectra.springboot.PizzaBunglow.model.AddOnsRequest;
import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequests;

public interface PizzaKitchen {
	
	public PizzaOrder Order(PizzaRequests pizzaRequest,List<AddOnsRequest> addOnsList, String phoneNumber, Date orderDate) throws Exception;

}
