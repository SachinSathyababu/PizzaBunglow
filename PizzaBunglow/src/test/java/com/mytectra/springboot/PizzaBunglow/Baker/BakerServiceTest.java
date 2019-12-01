package com.mytectra.springboot.PizzaBunglow.Baker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mytectra.springboot.PizzaBunglow.Store.AddOnStore;
import com.mytectra.springboot.PizzaBunglow.Store.PizzaStore;
import com.mytectra.springboot.PizzaBunglow.model.AddOns;
import com.mytectra.springboot.PizzaBunglow.model.AddOnsRequest;
import com.mytectra.springboot.PizzaBunglow.model.OrderItem;
import com.mytectra.springboot.PizzaBunglow.model.Pizza;
import com.mytectra.springboot.PizzaBunglow.model.PizzaOrder;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequest;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequest.Base;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequest.Size;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequests;

@ExtendWith(MockitoExtension.class)
public class BakerServiceTest {
	
		
	@Mock
	private PizzaStore pStore;
	
	@Mock
	private AddOnStore aStore;
	
	@InjectMocks
	private BakerService baker;
	
	@Test
	public void test_baker() {
		
		Pizza pizza= new Pizza(1, "Chicken Pizza", "Chicken Pizza with Spicy", 350);
		AddOns addOns= new AddOns(1, "Chicken Burger", "Chicken Burger with Spicy", 350);
		
		PizzaRequest pizzaRequest = new PizzaRequest();
		pizzaRequest.setBase(Base.NORMAL);
		pizzaRequest.setSize(Size.MEADIUM);
		pizzaRequest.setCount(2);
		pizzaRequest.setPizzaName("Chicken Pizza");
		
		AddOnsRequest addRequest = new AddOnsRequest();
		addRequest.setCount(3);
		addRequest.setName("Chicken Burger");
		
		Mockito.when(pStore.getPizzaByName(pizzaRequest.getPizzaName())).thenReturn(pizza);
		Mockito.when(aStore.getAddOnsByName(addRequest.getName())).thenReturn(addOns);
		
		PizzaRequests requests= new PizzaRequests();
		List<PizzaRequest> prequests= new ArrayList<PizzaRequest>();
		
		prequests.add(pizzaRequest);
		requests.setPizzaRequests(prequests);
		
		List<AddOnsRequest> arequests= new ArrayList<AddOnsRequest>();
		arequests.add(addRequest);
		
		PizzaOrder order= new PizzaOrder();
		try {
		 order=	baker.bake(requests, arequests);
		} catch (PizzaBakeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		assertEquals(2, order.getOrderItem().size());
		assertEquals("Thank You!", order.getMessage());
		
	}
	
	@Test
	public void test_baker_NullPizza() {
		
		
		AddOns addOns= new AddOns(1, "Chicken Burger", "Chicken Burger with Spicy", 350);
		
		PizzaRequest pizzaRequest = new PizzaRequest();
		pizzaRequest.setBase(Base.NORMAL);
		pizzaRequest.setSize(Size.MEADIUM);
		pizzaRequest.setCount(2);
		pizzaRequest.setPizzaName("Chicken Pizza");
		
		AddOnsRequest addRequest = new AddOnsRequest();
		addRequest.setCount(3);
		addRequest.setName("Chicken Burger");
		
		
		Mockito.lenient().when(aStore.getAddOnsByName(addRequest.getName())).thenReturn(addOns);
		
		PizzaRequests requests= new PizzaRequests();
		List<PizzaRequest> prequests= new ArrayList<PizzaRequest>();
		
		prequests.add(pizzaRequest);
		requests.setPizzaRequests(prequests);
		
		List<AddOnsRequest> arequests= new ArrayList<AddOnsRequest>();
		arequests.add(addRequest);
		
		assertThrows(PizzaBakeException.class, () -> baker.bake(requests, arequests));
		
	}
	
	@Test
	public void test_bakerNullAddOns() {
		
		Pizza pizza= new Pizza(1, "Chicken Pizza", "Chicken Pizza with Spicy", 350);
		
		PizzaRequest pizzaRequest = new PizzaRequest();
		pizzaRequest.setBase(Base.NORMAL);
		pizzaRequest.setSize(Size.MEADIUM);
		pizzaRequest.setCount(2);
		pizzaRequest.setPizzaName("Chicken Pizza");
		
		AddOnsRequest addRequest = new AddOnsRequest();
		addRequest.setCount(3);
		addRequest.setName("Chicken Burger");
		
		Mockito.lenient().when(pStore.getPizzaByName(pizzaRequest.getPizzaName())).thenReturn(pizza);
			
		PizzaRequests requests= new PizzaRequests();
		List<PizzaRequest> prequests= new ArrayList<PizzaRequest>();
		
		prequests.add(pizzaRequest);
		requests.setPizzaRequests(prequests);
		
		List<AddOnsRequest> arequests= new ArrayList<AddOnsRequest>();
		arequests.add(addRequest);
		
		assertThrows(PizzaBakeException.class, () -> baker.bake(requests, arequests));
	}
	
	
}
