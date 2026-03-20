package com.example.ecom.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom.product.entity.Product;
import com.example.ecom.product.model.ProductDto;
import com.example.ecom.product.repository.ProductRepository;



@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public void saveProduct(ProductDto productDto) {
	Product prod=	productRepository.save(mapDtoToEntity(productDto));
	System.out.println(prod.toString());
	}
	
	Product mapDtoToEntity(ProductDto dto)
	{
		Product prod = Product.builder()
				.category(dto.category())
				.inStock(dto.inStock())
				.name(dto.name())
				.price(dto.price())
				.build();
		return prod;
	}
}
