package com.programmingtechie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programmingtechie.domain.Order;

public interface OrderRepository extends 
JpaRepository<Order, Long> {

	 
	
}
