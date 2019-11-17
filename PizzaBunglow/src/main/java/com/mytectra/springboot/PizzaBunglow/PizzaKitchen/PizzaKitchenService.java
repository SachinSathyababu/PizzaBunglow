package com.mytectra.springboot.PizzaBunglow.PizzaKitchen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytectra.springboot.PizzaBunglow.Baker.Baker;
import com.mytectra.springboot.PizzaBunglow.Baker.PizzaBakeException;
import com.mytectra.springboot.PizzaBunglow.Billing.Billing;
import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder;
import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder.Status;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequest;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequests;

@Component
public class PizzaKitchenService implements PizzaKitchen{

	@Autowired
	private Baker bakerService;
	
	@Autowired
	private Billing billingService;
	
	@Override
	public PizzaOrder Order(PizzaRequests pizzaRequests) throws Exception {
		PizzaOrder order = bakerService.bake(pizzaRequests);
		billingService.bill(order);
		return order;
	}

	
	
}
