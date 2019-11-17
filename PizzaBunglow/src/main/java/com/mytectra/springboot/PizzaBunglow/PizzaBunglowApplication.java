package com.mytectra.springboot.PizzaBunglow;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mytectra.springboot.PizzaBunglow.PizzaKitchen.PizzaKitchenService;
import com.mytectra.springboot.PizzaBunglow.Store.PizzaStore;
import com.mytectra.springboot.PizzaBunglow.model.OrderItem;
import com.mytectra.springboot.PizzaBunglow.model.Pizza;
import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequest;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequest.Base;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequest.Size;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequests;

@SpringBootApplication
public class PizzaBunglowApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(PizzaBunglowApplication.class, args);
		PizzaKitchenService pizzaKit = ctx.getBean(PizzaKitchenService.class);
		
		 PizzaStore pizzaStore = ctx.getBean(PizzaStore.class);

		Pizza pizza= new Pizza();
		pizza.setName("Panner Pizza");
		pizza.setCost(300);
		pizza.setDescription("topped with panner");
		
		Pizza pizza1= new Pizza();
		pizza1.setName("Chicken Pizza");
		pizza1.setCost(450);
		pizza1.setDescription("topped with chicken");
		
		pizzaStore.addPizza(pizza);
		pizzaStore.addPizza(pizza1);
		
		
		PizzaRequest pizzaRequest = new PizzaRequest();
		pizzaRequest.setBase(Base.THIN);
		pizzaRequest.setPizzaName("Panner Pizza");
		pizzaRequest.setSize(Size.SMALL);
		pizzaRequest.setCount(2);
		
		PizzaRequest pizzaRequest1 = new PizzaRequest();
		pizzaRequest1.setBase(Base.THIN);
		pizzaRequest1.setPizzaName("Chicken Pizza");
		pizzaRequest1.setSize(Size.MEADIUM);
		pizzaRequest1.setCount(2);
		
		List<PizzaRequest> requestList= new ArrayList<PizzaRequest>();
		requestList.add(pizzaRequest);
		requestList.add(pizzaRequest1);
		
		PizzaRequests requests= new PizzaRequests();
		requests.setPizzaRequests(requestList);
		
		PizzaOrder recipt;
		try {
			recipt = pizzaKit.Order(requests);
			
			System.out.println("OrderId is "+recipt.getOrderId());
			System.out.println("Order Contents is");
			for(OrderItem OT: recipt.getPizzas()) {
				System.out.println(OT.getPizza().getName()+"-"+OT.getCount());
			}
			System.out.println("Order Status is "+recipt.getStatus());
			System.out.println("Order Cost Price  "+recipt.getPrice().getCostPrice());
			System.out.println("Order Discount  "+recipt.getPrice().getDiscount());
			System.out.println("Order Tax in Rs  "+recipt.getPrice().getTax());
			System.out.println("Order Final Cost "+recipt.getPrice().getFinalPrice());
			System.out.println(recipt.getMessage());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	}

}

