package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.dto.AddressDto;
import com.javaexpress.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = {"/api/address"})
@Slf4j
public class AddressController {

	@Autowired
	private  AddressService addressService;
	
	@PostMapping
	public AddressDto save(@RequestBody AddressDto addressDto) {
		return addressService.save(addressDto);
	}
	
	@GetMapping("{addressId}")
	public AddressDto findById(@PathVariable Integer addressId) {
		return addressService.findById(addressId);
	}
}