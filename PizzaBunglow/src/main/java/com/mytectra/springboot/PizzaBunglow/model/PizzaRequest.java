package com.mytectra.springboot.PizzaBunglow.model;

public class PizzaRequest {
	
	public enum Size { SMALL ,MEADIUM ,LARGE };
	
	public enum Base {THIN ,THICK ,NORMAL};
	
	private Size size;
	
	private Base base;
	
	private String pizzaName;
	
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
