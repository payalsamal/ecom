package com.example.ecom.seller.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom.seller.entity.Seller;
import com.example.ecom.seller.model.SellerDto;
import com.example.ecom.seller.repository.SellerRepository;

import jakarta.transaction.Transactional;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	@Transactional
	public void save(SellerDto seller) {
		repository.save(Seller.builder()
				.address(seller.address())
				.email(seller.email())
				.name(seller.name())
				.phone(seller.phone())
				.build());
		
	}
	
	public List<SellerDto>getAll(){
		return repository.findAll().stream().map(this::mapEntityToDto).toList();
		
	}
	SellerDto mapEntityToDto(Seller seller) {
		return  SellerDto.builder()
				.address(seller.getAddress())
				.id(seller.getId())
				.verified(seller.isVerified())
				.email(seller.getEmail())
				.phone(seller.getPhone())
				.name(seller.getName())
				.build();
	}

}
