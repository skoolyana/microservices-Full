package com.programmingtechie.dto;

import java.util.List;

import com.programmingtechie.domain.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

	private List<OrderLineItemsDTO> orderLineItemsDtoList;	  
}
