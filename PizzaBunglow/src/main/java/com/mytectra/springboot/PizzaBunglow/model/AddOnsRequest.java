package com.mytectra.springboot.PizzaBunglow.model;

import com.mytectra.springboot.PizzaBunglow.model.PizzaRequest.Base;
import com.mytectra.springboot.PizzaBunglow.model.PizzaRequest.Size;

public class AddOnsRequest {
	
	private String name;
	
	private int count;
	
	public AddOnsRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
}
