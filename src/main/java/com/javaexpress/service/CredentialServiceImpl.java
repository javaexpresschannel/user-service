package com.javaexpress.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.CredentialDto;
import com.javaexpress.helper.CredentialMappingHelper;
import com.javaexpress.model.Credential;
import com.javaexpress.repository.CredentialRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CredentialServiceImpl {

	@Autowired
	private CredentialRepository credentialRepository;
	
	public CredentialDto findByUsername(String username) {
		Optional<Credential> optional = credentialRepository.findByUsername(username);
		if(optional.isPresent()) {
			Credential dbCredential = optional.get();
			return CredentialMappingHelper.map(dbCredential);
		} else {
			throw new RuntimeException("UserName not found in Db");
		}
	}
	
}
