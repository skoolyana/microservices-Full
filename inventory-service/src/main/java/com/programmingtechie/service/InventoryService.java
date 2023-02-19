package com.programmingtechie.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programmingtechie.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

	private final InventoryRepository inventoryRepository;

	
	@Transactional(readOnly = true)
	public boolean isInStock(String skucode) {

		return inventoryRepository.findBySkuCode(skucode).isPresent();
	}

}
