package com.javaexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
