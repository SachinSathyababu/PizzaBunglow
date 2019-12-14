package com.mytectra.springboot.PizzaBunglow.Store;

import java.util.List;

import com.mytectra.springboot.PizzaBunglow.model.AddOns;

public interface AddOnStore {

	public void addAddOns(AddOns addOns);
	
	public List<AddOns> getAllAddOns();
	
	public AddOns getAddOnsByName(String addOnsName);
	
	public AddOns getAddOnsById(int id);
	
	public boolean updateAddOnsById(AddOns addOns);
	
	public boolean deleteAddOnsById(int id);
}
