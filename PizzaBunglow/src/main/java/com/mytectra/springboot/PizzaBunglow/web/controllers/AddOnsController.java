package com.mytectra.springboot.PizzaBunglow.web.controllers;

import java.util.List;

import org.assertj.core.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mytectra.springboot.PizzaBunglow.Store.AddOnStore;
import com.mytectra.springboot.PizzaBunglow.model.AddOns;


@Validated
@RestController
public class AddOnsController {

	@Autowired
	private AddOnStore addOnsStore;
	
	@GetMapping("/addOns")
 	public @ResponseBody List<AddOns> getAddOns(){
		return addOnsStore.getAllAddOns();
 	}
	
	@GetMapping("/addOns/search")
 	public AddOns getAddOn(@RequestParam (name="name") @NonNull String name){
		AddOns addOn= addOnsStore.getAddOnsByName(name);
		return addOn;
 	}
	
	@PostMapping("/addOns")
	public String AddaddOns(@RequestBody AddOns addOns) {
		addOnsStore.addAddOns(addOns);
		return "Success";
	}

	@GetMapping("/addOns/{id}")
	public AddOns getAddOns(@PathVariable("id") Integer id, @RequestHeader(name = "client" ,required = false) String client) {
		System.out.println("Client is "+client);
		return addOnsStore.getAddOnsById(id);
	}
	
	@PutMapping("/addOns/{id}")
	public String updateAddOns(@PathVariable("id") Integer id, @RequestBody AddOns addOns, 
			@RequestHeader(name = "clientName" ,required = false) String client,
			@RequestHeader(name = "clientId" ,required = false) String clientId) {
		addOns.setId(id);
		
		if(addOnsStore.updateAddOnsById(addOns)) {
			return "Success";
		}else {
			return "Failure";
		}
	}
	
	@DeleteMapping("/addOns/{id}")
	public String deleteAddOns(@PathVariable("id") Integer id) {
		if(addOnsStore.deleteAddOnsById(id)) {
			return "Success";
		}else {
			return "Failure";
		}
	}
}
