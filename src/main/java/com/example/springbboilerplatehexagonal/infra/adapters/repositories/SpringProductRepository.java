package com.example.springbboilerplatehexagonal.infra.adapters.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbboilerplatehexagonal.infra.adapters.entities.ProductEntity;

@Repository
public interface SpringProductRepository extends JpaRepository<ProductEntity, UUID> {
    
    Optional<ProductEntity> findBySku(String sku);

}