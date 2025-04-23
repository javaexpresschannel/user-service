package com.javaexpress.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserDto {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String email; // pojo class name and db column name both are same
	private String phone;
	
	@JsonProperty("credentail")
	@JsonInclude(value=Include.NON_NULL)
	private CredentialDto credentialDto;
	
	private Set<AddressDto> addressDtos;
}

// credential