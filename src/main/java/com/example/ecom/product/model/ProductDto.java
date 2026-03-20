package com.example.ecom.product.model;

import lombok.Builder;

@Builder
public record ProductDto(
		
		String id,

		     String name,
		     double price,
		     String category,
		     boolean inStock) {

}
