package com.javaexpress.helper;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dto.CredentialDto;
import com.javaexpress.dto.UserDto;
import com.javaexpress.model.Credential;

public interface CredentialMappingHelper {

	public static CredentialDto map(Credential credential) {
		CredentialDto credentialDto = new CredentialDto();
		BeanUtils.copyProperties(credential, credentialDto);
		
		
		if(credential.getUser() !=null) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(credential.getUser(), userDto);
			credentialDto.setUserDto(userDto);
		}
		return credentialDto;
	}
}
