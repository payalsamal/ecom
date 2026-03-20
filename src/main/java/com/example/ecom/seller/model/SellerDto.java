package com.example.ecom.seller.model;

import lombok.Builder;

@Builder
public record SellerDto(
        Long id,
        String name,
        String email,
        String phone,
        String address,
        boolean verified
) { }
