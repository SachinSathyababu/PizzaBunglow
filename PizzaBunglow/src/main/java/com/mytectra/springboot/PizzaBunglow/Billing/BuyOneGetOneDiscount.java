package com.mytectra.springboot.PizzaBunglow.Billing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mytectra.springboot.PizzaBunglow.model.OrderItem;
import com.mytectra.springboot.PizzaBunglow.model.Pizza;
import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder;

@Component
public class BuyOneGetOneDiscount implements Discount{

	@Override
	public double discount(PizzaOrder order) {
		// TODO Auto-generated method stub
		
		for(OrderItem item: order.getPizzas()) {
			if(item.getPizza().getName().equalsIgnoreCase("Panner Pizza")) {
				
				int count= item.getCount();
				for(int i=1; i<=count;i++) {
				item.setCount(item.getCount()+1);
				}
			}
		}
		
		
		return 0;
	}

}
