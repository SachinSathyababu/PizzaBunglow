package com.mytectra.springboot.PizzaBunglow.Store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mytectra.springboot.PizzaBunglow.model.AddOns;
@Component
public class AddOnsStoreService implements AddOnStore{

	List<AddOns> addOnsList= new ArrayList<AddOns>();
	@Override
	public void addAddOns(AddOns addOns) {
		// TODO Auto-generated method stub
		addOnsList.add(addOns);
	}

	@Override
	public List<AddOns> getAllAddOns() {
		// TODO Auto-generated method stub
		return addOnsList;
	}

	@Override
	public AddOns getAddOnsByName(String addOnsName) {
		// TODO Auto-generated method stub
		for(AddOns addOns: addOnsList) {
			if(addOns.getName().equalsIgnoreCase(addOnsName)) {
				return addOns;
			}
		}
		return null;
	}

	
}
