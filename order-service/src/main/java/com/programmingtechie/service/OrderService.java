package com.programmingtechie.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programmingtechie.domain.Order;
import com.programmingtechie.domain.OrderLineItems;
import com.programmingtechie.dto.OrderLineItemsDTO;
import com.programmingtechie.dto.OrderRequest;
import com.programmingtechie.repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class OrderService {

	private final OrderRepository orderRepository;

	public void placeOrder(OrderRequest orderRequest) {
		
		Order order = new Order();

		order.setOrderNumber(UUID.randomUUID().toString());

		List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList().stream()
				.map(orderLineItemsDto -> maptoDto(orderLineItemsDto)).toList();

		order.setOrderLineItemsList(orderLineItemsList);

		orderRepository.save(order);

	}

	private OrderLineItems maptoDto(OrderLineItemsDTO orderLineItemsDto) {

		OrderLineItems orderLineItems = new OrderLineItems();

		orderLineItems.setPrice(orderLineItemsDto.getPrice());

		orderLineItems.setQuanitity(orderLineItemsDto.getQuanitity());

		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());

		return orderLineItems;
	}

}
