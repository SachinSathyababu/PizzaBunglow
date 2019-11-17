package com.mytectra.springboot.PizzaBunglow.Billing;

import org.springframework.stereotype.Component;

import com.mytectra.springboot.PizzaBunglow.model.OrderItem;
import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder;

@Component
public class Flat20Discount implements Discount {



	@Override
	public double discount(PizzaOrder order) {
		double discount=0;
		if(order.getPrice() != null ) {
			
			for(OrderItem item: order.getPizzas()) {
			if(!(item.getPizza().getName().equalsIgnoreCase("Panner Pizza"))){	
			 discount = discount+item.getPizza().getCost() * 0.2 * item.getCount();
			}
			}
			return discount;
		} else {
			throw new IllegalArgumentException("No Price yest calculated");
		}
		
	}

}
