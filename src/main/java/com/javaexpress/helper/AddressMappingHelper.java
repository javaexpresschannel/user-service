package com.javaexpress.helper;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dto.AddressDto;
import com.javaexpress.dto.UserDto;
import com.javaexpress.model.Address;
import com.javaexpress.model.User;

public interface AddressMappingHelper {

	public static AddressDto map(Address address) {
		
		AddressDto addressDto = new AddressDto();
        BeanUtils.copyProperties(address, addressDto);

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(address.getUser(), userDto);

        addressDto.setUserDto(userDto);
        return addressDto;
	}
	
	
	public static Address map(AddressDto addressDto) {
		Address address = new Address();
		BeanUtils.copyProperties(addressDto, address);
		
//		User user = new User();
//		BeanUtils.copyProperties(addressDto.getUserDto(), user);
//		
//		address.setUser(user);
		return address;
	}
}
