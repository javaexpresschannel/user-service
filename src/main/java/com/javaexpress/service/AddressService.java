package com.javaexpress.service;

import com.javaexpress.dto.AddressDto;

public interface AddressService {

	AddressDto save(AddressDto addressDto);
	AddressDto findById(Integer addressId);
}
