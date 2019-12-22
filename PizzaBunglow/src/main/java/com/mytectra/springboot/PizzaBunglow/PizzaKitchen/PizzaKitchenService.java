package com.mytectra.springboot.PizzaBunglow.PizzaKitchen;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytectra.springboot.PizzaBunglow.Baker.Baker;
import com.mytectra.springboot.PizzaBunglow.Baker.PizzaBakeException;
import com.mytectra.springboot.PizzaBunglow.Billing.Billing;
import com.mytectra.springboot.PizzaBunglow.model.AddOnsRequest;
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
	public PizzaOrder Order(PizzaRequests pizzaRequests, List<AddOnsRequest> addOnsList, String phoneNumber, Date orderDate) 	 {
		PizzaOrder order= new PizzaOrder();
		try {
			order = bakerService.bake(pizzaRequests, addOnsList);
			billingService.bill(order);
			order.setPhoneNumber(phoneNumber);
			order.setOrderDate(orderDate);
		} catch (PizzaBakeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return order;
	}

	
	
}
