package com.example.ecom.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecom.product.entity.Product;
import com.example.ecom.product.model.ProductDto;
import com.example.ecom.product.model.ProductList;
import com.example.ecom.product.repository.ProductRepository;
import org.springframework.data.domain.Page;
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Transactional
	public void saveProduct(ProductDto productDto) {
		Product prod = productRepository.save(mapDtoToEntity(productDto));
		System.out.println(prod.toString());
	}
	@Transactional
	public void saveAllProduct(List<ProductDto> productDto) {
		productRepository.saveAll(productDto.stream().map(x->mapDtoToEntity(x)).toList());
		
	}

	Product mapDtoToEntity(ProductDto dto) {
		Product prod = Product.builder().category(dto.category()).inStock(dto.inStock()).name(dto.name())
				.price(dto.price()).build();
		return prod;
	}

	public List<ProductDto> getAll() {

		return (productRepository.findAll().stream().map(this::mapEntityToDto).toList());

	}

	ProductDto mapEntityToDto(Product dto) {
		ProductDto prod = ProductDto.builder().category(dto.getCategory()).inStock(dto.isInStock()).name(dto.getName())
				.price(dto.getPrice()).id(dto.getId()).build();
		return prod;
	}

	public List<ProductDto> getAllInstock() {

		return (productRepository.findAll().stream().map(this::mapEntityToDto).filter(ProductDto::inStock).toList());

	}

	public ProductList getAllWithPagination(Integer pageNo, Integer pageSize) {
		Pageable page = PageRequest.of(pageNo, pageSize);
		
		Page<Product> data = productRepository.findAll(page);
		return  ProductList.builder().products( data.getContent().stream().map(this::mapEntityToDto).toList())
				.totalPage(data.getTotalPages()).build()
				;

	}

}
