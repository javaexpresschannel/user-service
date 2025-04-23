package com.javaexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.AddressDto;
import com.javaexpress.helper.AddressMappingHelper;
import com.javaexpress.model.Address;
import com.javaexpress.model.User;
import com.javaexpress.repository.AddressRepository;
import com.javaexpress.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public AddressDto save(AddressDto addressDto) {
		
		Integer userId = addressDto.getUserDto().getUserId();
		User dbUser = userRepository.findById(userId)
			.orElseThrow(() -> new RuntimeException("User Not Found"));
		Address address = AddressMappingHelper.map(addressDto);
		address.setUser(dbUser);
		Address dbAddress = addressRepository.save(address);
		
		return AddressMappingHelper.map(dbAddress);
	}

	@Override
	public AddressDto findById(Integer addressId) {
		return addressRepository.findById(addressId)
				.map(AddressMappingHelper::map)
				.orElseThrow(() -> new RuntimeException("AddressNotFoundException"));
	}

	
}
