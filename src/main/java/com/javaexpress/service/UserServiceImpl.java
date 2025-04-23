package com.javaexpress.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.UserDto;
import com.javaexpress.helper.UserMappingHelper;
import com.javaexpress.model.User;
import com.javaexpress.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto save(UserDto userDto) {
		
		String rawPassword = userDto.getCredentialDto().getPassword();
		userDto.getCredentialDto().setPassword(passwordEncoder.encode(rawPassword));
		
		User user = UserMappingHelper.map(userDto);
		log.info("user {}",user);
		User dbUser = userRepository.save(user);
		UserDto result = UserMappingHelper.map(dbUser);
		return result;
	}

	@Override
	public UserDto findById(Integer userId) {
		return userRepository.findById(userId)
				.map(UserMappingHelper::map)
				.orElseThrow(() -> new RuntimeException("User not found in Db"));
	}

	@Override
	public List<UserDto> findAll() {
		return userRepository.findAll().stream()
				.sorted(Comparator.comparing(User::getUserId))
				.map(UserMappingHelper::map)
				.collect(Collectors.toList());
	}

	@Override
	public UserDto update(Integer userId, UserDto userDto) {
		// userId, credentialId
		User dbUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(""));
		BeanUtils.copyProperties(userDto, dbUser,"credential");
		User updatedUser = userRepository.save(dbUser);
		return UserMappingHelper.map(updatedUser);
	}

	@Override
	public void delteById(Integer userId) {
		userRepository.deleteById(userId);
	}

	public UserDto findByUsername(String username) {
		log.info("UserService :: findByUsername");
		return UserMappingHelper.map(
				userRepository.findByCredentialUsername(username)
				.orElseThrow(() -> new RuntimeException("User Not Found")));
	}
}
