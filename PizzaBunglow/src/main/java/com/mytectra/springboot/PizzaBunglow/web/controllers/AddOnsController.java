package com.mytectra.springboot.PizzaBunglow.web.controllers;

import java.util.List;

import org.assertj.core.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.mytectra.springboot.PizzaBunglow.web.controllers.model.ResponseWrapper;
import com.mytectra.springboot.PizzaBunglow.web.controllers.model.ResponseWrapper.Status;


@Validated
@RestController
public class AddOnsController {

	@Autowired
	private AddOnStore addOnsStore;
	
	@GetMapping(path="/addOns", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
 	public @ResponseBody List<AddOns> getAddOns(){
		return addOnsStore.getAllAddOns();
 	}
	
	@GetMapping(path="/addOns/search", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
 	public AddOns getAddOn(@RequestParam (name="name") @NonNull String name){
		AddOns addOn= addOnsStore.getAddOnsByName(name);
		return addOn;
 	}
	
	@GetMapping(path="/addOns/{id}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public AddOns getAddOns(@PathVariable("id") Integer id, @RequestHeader(name = "client" ,required = false) String client) {
		System.out.println("Client is "+client);
		return addOnsStore.getAddOnsById(id);
	}
	
	@PostMapping(path="/addOns", consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseWrapper<?> AddaddOns(@RequestBody AddOns addOns) {
		addOnsStore.addAddOns(addOns);
		return new ResponseWrapper<String>("Successfully Added", Status.SUCCESS);
	}
	
	@PutMapping(path="/addOns/{id}", consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseWrapper<?> updateAddOns(@PathVariable("id") Integer id, @RequestBody AddOns addOns, 
			@RequestHeader(name = "clientName" ,required = false) String client,
			@RequestHeader(name = "clientId" ,required = false) String clientId) {
		addOns.setId(id);
		
		if(addOnsStore.updateAddOnsById(addOns)) {
			return new ResponseWrapper<String>("Successfully Updated", Status.SUCCESS);
		}else {
			return new ResponseWrapper<String>("Failed to Update", Status.FAILURE);
		}
	}
	
	@DeleteMapping(path="/addOns/{id}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseWrapper<?> deleteAddOns(@PathVariable("id") Integer id) {
		if(addOnsStore.deleteAddOnsById(id)) {
			return new ResponseWrapper<String>("Successfully Deleted", Status.SUCCESS);
		}else {
			return new ResponseWrapper<String>("Failed to delete", Status.FAILURE);
		}
	}
}
