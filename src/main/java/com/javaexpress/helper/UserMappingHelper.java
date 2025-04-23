package com.javaexpress.helper;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dto.CredentialDto;
import com.javaexpress.dto.UserDto;
import com.javaexpress.model.Credential;
import com.javaexpress.model.User;

public interface UserMappingHelper {

	public static User map(UserDto userDto) {

		User user = new User();
		BeanUtils.copyProperties(userDto, user);

		if (userDto.getCredentialDto() != null) {
			Credential credential = new Credential();
			BeanUtils.copyProperties(userDto.getCredentialDto(), credential);
			
			credential.setUser(user);
			user.setCredential(credential);
		}

		return user;
	}

	public static UserDto map(User user) {
		if(user == null) {
			return null;
		}
		UserDto userDto =new UserDto();
		BeanUtils.copyProperties(user, userDto);
		
		if(user.getCredential() != null) {
			CredentialDto credentialDto = new CredentialDto();
			BeanUtils.copyProperties(user.getCredential(), credentialDto);
			userDto.setCredentialDto(credentialDto);
		}
		return userDto;
	}

}
