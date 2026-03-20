package com.example.ecom.seller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecom.seller.entity.Seller;
@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{

}
