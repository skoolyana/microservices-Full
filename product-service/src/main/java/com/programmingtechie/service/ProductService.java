package com.programmingtechie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.programmingtechie.domain.Product;
import com.programmingtechie.dto.ProductRequest;
import com.programmingtechie.dto.ProductResponse;
import com.programmingtechie.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;
	
	public void createProduct(ProductRequest productRequest) {
	
		Product product = Product.builder().
				name(productRequest.getName()).description(productRequest.getDescription())
				.price(productRequest.getPrice()).build();
		
		productRepository.save(product);
	
		log.info("Product with {} us saved",product.getId());
	
	}

	public List<ProductResponse> getAllProducts() {
		// TODO Auto-generated method stub
		
		List<Product> products = productRepository.findAll();
		
		return products.stream().map(product-> 
		mapToProductResponse(product)).toList();
	
	}

	private ProductResponse mapToProductResponse(Product product) {
		// TODO Auto-generated method stub
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}
	
	
	
	
}
