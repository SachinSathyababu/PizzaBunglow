package com.mytectra.springboot.PizzaBunglow.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mytectra.springboot.PizzaBunglow.Store.AddOnStore;
import com.mytectra.springboot.PizzaBunglow.model.AddOns;
import com.mytectra.springboot.PizzaBunglow.model.Pizza;

@RestController
public class AddOnsController {

	@Autowired
	private AddOnStore addOnsStore;
	
	@GetMapping("/addOns")
 	public List<AddOns> getAddOns(){
 		return addOnsStore.getAllAddOns();
 	}
	
	@GetMapping("/addOns/search")
 	public AddOns getAddOn(@RequestParam (name="name") String name){
		AddOns addOn= addOnsStore.getAddOnsByName(name);
		return addOn;
 	}
	
	@PostMapping("/addOns")
	public String AddaddOns(@RequestBody AddOns addOns) {
		addOnsStore.addAddOns(addOns);
		return "Success";
	}

}
