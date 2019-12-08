package com.mytectra.springboot.PizzaBunglow.Billing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.mytectra.springboot.PizzaBunglow.model.OrderItem;
import com.mytectra.springboot.PizzaBunglow.model.Pizza;
import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder;
import com.mytectra.springboot.PizzaBunglow.model.Price;

@Component
@ConditionalOnProperty(name="pizza.billing", havingValue="true")

public class BillingService implements Billing{

	//@Value("${pizza.tax}")
	private int tax = 18;
	
	@Autowired
	private List<Discount> discounts;
	
	
	/*public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}*/
	
	@Override
	public void bill(PizzaOrder order) {
		Price price= new Price();
		order.setPrice(price);
		double totalPrice = 0;
		for(OrderItem item : order.getOrderItem()) {
			
			if(item.getPizza()!=null) {
			totalPrice += (item.getPizza().getCost() * item.getCount());
			}
			
			if(item.getAddOns()!=null) {
				totalPrice += (item.getAddOns().getCost() * item.getCount());
			}
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
