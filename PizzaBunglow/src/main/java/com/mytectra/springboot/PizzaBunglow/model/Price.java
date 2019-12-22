package com.mytectra.springboot.PizzaBunglow.model;

import javax.validation.constraints.Positive;

public class Price {
	
	@Positive(message = "costPrice cannot be negative number")
	private double costPrice;
	
	@Positive(message = "discount cannot be negative number")
	private double discount;
	
	@Positive(message = "tax cannot be negative number")
	private double tax;
	
	@Positive(message = "finalPrice cannot be negative number")
	private double finalPrice;
	
	public Price() {}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	
	
	

}
