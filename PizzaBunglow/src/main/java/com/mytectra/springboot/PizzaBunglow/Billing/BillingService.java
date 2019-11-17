package com.mytectra.springboot.PizzaBunglow.Billing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mytectra.springboot.PizzaBunglow.model.OrderItem;
import com.mytectra.springboot.PizzaBunglow.model.Pizza;
import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder;
import com.mytectra.springboot.PizzaBunglow.model.Price;

@Component
public class BillingService implements Billing{

	@Value("${pizza.tax}")
	private int tax;
	
	@Autowired
	private List<Discount> discounts;
	
	@Override
	public void bill(PizzaOrder order) {
		Price price= new Price();
		order.setPrice(price);
		double totalPrice = 0;
		for(OrderItem item : order.getPizzas()) {
			totalPrice += (item.getPizza().getCost() * item.getCount());
		}
		price.setCostPrice(totalPrice);
		double discount = 0;
		for(Discount dis : discounts) {
			discount += dis.discount(order);
		}
		totalPrice += -(discount);
		price.setDiscount(discount);
		double taxCalc = (totalPrice * tax)/100;
		double finalPrice = totalPrice + taxCalc;
		price.setTax(taxCalc);
		price.setFinalPrice(finalPrice);
	}

}
