package com.example.ecom.inventory.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.ecom.config.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_seq")
    @SequenceGenerator(
            name = "inventory_seq",
            sequenceName = "inventory_seq",
            allocationSize = 50
    )
    private Long id;

    @Column(nullable = false)
    private String productCode;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer reservedQuantity;

    @Column(nullable = false)
    private Integer availableQuantity;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String warehouseLocation;

    @Column(nullable = false)
    private Boolean active;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime modifiedOn;

   
}
