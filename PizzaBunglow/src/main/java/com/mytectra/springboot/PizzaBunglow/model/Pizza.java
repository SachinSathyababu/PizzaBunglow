package com.mytectra.springboot.PizzaBunglow.model;

import java.util.List;

public class Pizza {
	
	private int id;
	private String name;
	private String description;
	private int cost;
	
	public Pizza() {}

	public Pizza(int id, String name, String description, int cost) {
		super();
		this.id=id;
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

