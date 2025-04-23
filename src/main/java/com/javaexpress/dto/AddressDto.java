package com.javaexpress.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddressDto {

	private Integer addressId;
	
	private String fullAddress;
	private String postalCode;
	private String city;
	
	@JsonProperty("user")
	private UserDto userDto;
}
