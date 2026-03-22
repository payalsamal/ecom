package com.example.ecom.product.model;

import java.util.List;

import lombok.Builder;
@Builder
public record ProductList(List<ProductDto>products, Integer totalPage) {

}
