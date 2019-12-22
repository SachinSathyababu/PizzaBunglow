package com.mytectra.springboot.PizzaBunglow.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PizzaRequest {
	
	public enum Size { SMALL ,MEADIUM ,LARGE };
	
	public enum Base {THIN ,THICK ,NORMAL};
	
	@NotEmpty(message = "Pizza Size Cannot be empty or null")	
	@NotBlank(message ="Pizza Size Cannot be white spaces")
	private Size size;
	
	@NotEmpty(message = "Pizza base Name Cannot be empty or null")	
	@NotBlank(message ="Pizza base Cannot be white spaces")
	private Base base;
	
	@NotEmpty(message = "Pizza Name Cannot be empty or null")	
	@NotBlank(message ="Pizza Name Cannot be white spaces")
	//@Size
	private String pizzaName;
	
	@Positive(message = "cannot be negative number")
	private int count;
	
	public PizzaRequest() {}
	
	public Size getSize() {
		return size;
	}


	public void setSize(Size size) {
		this.size = size;
	}


	public Base getBase() {
		return base;
	}


	public void setBase(Base base) {
		this.base = base;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	
	public String getPizzaName() {
		return pizzaName;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
