package com.example.ecom.product.service;

import java.util.List;

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
	
	public List<ProductDto> getAll() {
		
			return (productRepository.findAll().stream().map(this::mapEntityToDto).toList());
		
		}
	ProductDto mapEntityToDto(Product dto)
	{
		ProductDto prod = ProductDto.builder()
				.category(dto.getCategory())
				.inStock(dto.isInStock())
				.name(dto.getName())
				.price(dto.getPrice())
				.id(dto.getId())
				.build();
		return prod;
	}
	public List<ProductDto> getAllInstock() {
		
		return (productRepository.findAll().stream().map(this::mapEntityToDto).filter(ProductDto::inStock).toList());
	
	}
}
