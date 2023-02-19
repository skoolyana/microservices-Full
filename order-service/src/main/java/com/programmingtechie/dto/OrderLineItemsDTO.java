package com.programmingtechie.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDTO {

	private Long id;

	private String skuCode;

	private BigDecimal price;

	private Integer quanitity;

}
