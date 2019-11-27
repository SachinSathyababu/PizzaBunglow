package com.mytectra.springboot.PizzaBunglow.Billing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mytectra.springboot.PizzaBunglow.model.AddOns;
import com.mytectra.springboot.PizzaBunglow.model.OrderItem;
import com.mytectra.springboot.PizzaBunglow.model.Pizza;
import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder;

@ExtendWith(MockitoExtension.class)
public class BillingServiceTest {
	
	@Mock 
	private Discount disc1;
	
	@Mock
	private Discount disc2;
	
	@Spy
	private List<Discount> discs = new ArrayList<>();
	
	@InjectMocks
	private BillingService billingService;
	

	@BeforeEach
	private void init()
	{
		discs.add(disc1);
		discs.add(disc2);
	}
	
	@Test
	public void testBilling() {
		
		PizzaOrder order = new PizzaOrder();
		OrderItem item = new OrderItem(new Pizza(1, "x piza", "", 100), 2);
		OrderItem item1 = new OrderItem(new AddOns(1, "x fries", "", 100), 2);
		order.addOrder(item);
		order.addOrder(item1);
		
		Mockito.when(disc1.discount(order)).thenReturn(40.0);
		Mockito.when(disc2.discount(order)).thenReturn(10.0);
		
		
		billingService.bill(order);
		
		assertNotNull(order.getPrice());
		assertEquals(400, order.getPrice().getCostPrice() , "Inccorect CP");
		assertEquals(50, order.getPrice().getDiscount(),"Inccorect Dis");
		assertEquals(63, order.getPrice().getTax(),"Inccorect tax");
		assertEquals(413, order.getPrice().getFinalPrice(),"Inccorect fP");
	
	}

}
