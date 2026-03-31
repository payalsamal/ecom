package com.example.ecom.seller.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom.seller.entity.Seller;
import com.example.ecom.seller.model.SellerDto;
import com.example.ecom.seller.repository.SellerRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	@Autowired
	private EntityManager entityManager;
	
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
	
	Seller mapDtoToEntity(SellerDto seller) {
		return  Seller.builder()
				.address(seller.address())
				.id(seller.id())
				.verified(seller.verified())
				.email(seller.email())
				.phone(seller.phone())
				.name(seller.name())
				.build();
	}
	
	@Transactional
	public void saveAll(List<SellerDto> sellers) {
		
		batchInsert(sellers.stream().map(x->mapDtoToEntity(x)).toList());
	}
	
	@Transactional
	public void batchInsert(List<Seller> list) {
	 int batchSize = 1000;
	 for (int i = 0; i < list.size(); i++) {
	 entityManager.persist(list.get(i));

	 if (i % batchSize == 0) {
	 entityManager.flush();
	 entityManager.clear();
	 }
	 }
	 entityManager.flush();
	 entityManager.clear();
	}

}
