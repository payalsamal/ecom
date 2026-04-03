package com.example.ecom.product.controller;



import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.ecom.product.model.ProductDto;
import com.example.ecom.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductGraphQLController {

	
	
	private final  ProductService service;
	
	@QueryMapping
	public List<ProductDto>getProducts(){
		return service.getAll();
	}
}
