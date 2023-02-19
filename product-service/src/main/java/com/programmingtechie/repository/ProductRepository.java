package com.programmingtechie.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.programmingtechie.domain.Product;


public interface ProductRepository extends 
MongoRepository<Product, String> {

	
	 
}
