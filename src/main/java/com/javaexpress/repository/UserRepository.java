package com.javaexpress.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// fetch userdetails by username
	// input username
	// ouput User
	
	Optional<User> findByCredentialUsername(String username);
	
	//@Query(name="select username,firstName from user",nativeQuery = true)
	//List<Object[]> fetchUserInformation(Integer id);
}
