package com.example.ecom.product.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.ecom.product.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
