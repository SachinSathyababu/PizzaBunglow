package com.mytectra.springboot.PizzaBunglow.Billing;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.mytectra.springboot.PizzaBunglow.model.OrderItem;
import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder;

@Component
@ConditionalOnProperty(name="pizza.Flat20", havingValue="true")
public class Flat20Discount implements Discount {



	@Override
	public double discount(PizzaOrder order) {
		if(order == null) {
			throw new  IllegalArgumentException("Order cannot be null");
		}
		
		double discount=0;
			
			for(OrderItem item: order.getOrderItem()) {
			if(item.getPizza()!=null && !(item.getPizza().getName().equalsIgnoreCase("Panner Pizza")))
			{	
			 discount = discount+item.getPizza().getCost() * 0.2 * item.getCount();
			}
			
			if(item.getAddOns()!=null && !(item.getAddOns().getName().equalsIgnoreCase("Fries")))
			{	
			 discount = discount+item.getAddOns().getCost() * 0.2 * item.getCount();
			}
			}
			return discount;
	}

}
