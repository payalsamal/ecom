package com.example.ecom.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.product.model.ProductDto;
import com.example.ecom.product.service.ProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	ResponseEntity<String>saveProduct(@RequestBody ProductDto productDto){
		productService.saveProduct(productDto);
		return  new ResponseEntity<String>("Saved successfully", HttpStatus.CREATED );
	}
}
