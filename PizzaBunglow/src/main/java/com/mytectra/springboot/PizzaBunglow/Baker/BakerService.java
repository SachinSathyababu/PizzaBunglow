package com.mytectra.springboot.PizzaBunglow.Baker;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytectra.springboot.PizzaBunglow.Store.PizzaStore;
import com.mytectra.springboot.PizzaBunglow.model.OrderItem;
import com.mytectra.springboot.PizzaBunglow.model.Pizza;
import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder;
import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder.Status;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequest;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequests;

@Component
public class BakerService implements Baker{
	
	@Autowired
	private PizzaStore pizzaStore;
	
	
	@Override
	public PizzaOrder bake(PizzaRequests pizzaRequests) throws PizzaBakeException {
		PizzaOrder order = new PizzaOrder();
		order.setOrderId(new Random().nextInt());
		for(PizzaRequest request : pizzaRequests.getPizzaRequests() ) {
			Pizza pizza = pizzaStore.getPizzaByName(request.getPizzaName());
			if(pizza != null) {
			order.addOrder(new OrderItem(pizza, request.getCount()));
			} else {
				throw new PizzaBakeException("Sorry we cannot deliver - "+ request.getPizzaName() + " we dont have it right now" );
			}
		}
		order.setStatus(Status.PROCESSING);
		order.setMessage("Thank You!");
		return order;
	}

	
	
}
