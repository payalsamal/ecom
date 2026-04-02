package com.example.ecom.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.product.model.ProductDto;
import com.example.ecom.product.model.ProductList;
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
	@GetMapping(version="1")
	ResponseEntity<List<ProductDto>>getAllProduct(){
		return  new ResponseEntity<List<ProductDto>>(productService.getAll(),HttpStatus.OK);
	}
	@GetMapping(version="2")
	ResponseEntity<List<ProductDto>>getAllProductv2(){
		return  new ResponseEntity<List<ProductDto>>(productService.getAllInstock(),HttpStatus.OK);
	}
	@GetMapping(version="3")
	ResponseEntity<ProductList>getAllProductPaginatio(@RequestParam Integer
			pageNo, @RequestParam Integer size ){
		return  new ResponseEntity<ProductList>(productService.getAllWithPagination(pageNo,size),HttpStatus.OK);
	}
	
	@PostMapping
	ResponseEntity<List<ProductDto>>saveAllProduct(@RequestBody List<ProductDto> productDto){
		;
		return  new ResponseEntity<List<ProductDto>>(productService.saveAllProduct(productDto), HttpStatus.CREATED );
	}
}
