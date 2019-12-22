package com.mytectra.springboot.PizzaBunglow.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class AddOns {
	
	@Positive(message = "cannot be negative number")
	private int id;
	
	@NotEmpty(message = "AddOns Name Cannot be empty or null")	
	@Size(min = 3 , max = 50 , message = "Size to be between 3 - 50 length")
	@NotBlank(message ="Addons Name Cannot be white spaces")
	private String name;
	
	@NotEmpty(message = "Addons description Cannot be empty or null")	
	@Size(min = 3 , max = 50 , message = "Size to be between 3 - 50 length")
	@NotBlank(message ="Addons description Cannot be white spaces")
	private String description;
	
	@Positive(message = "cannot be negative number")
	private int cost;
	
	public AddOns() {		}
	
	

	public AddOns(int id, String name, String description, int cost) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cost = cost;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	
}
