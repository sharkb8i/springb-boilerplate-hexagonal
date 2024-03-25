package com.example.springbboilerplatehexagonal.domain.ports.repositories;

import java.util.List;

import com.example.springbboilerplatehexagonal.domain.Product;

public interface ProductRepositoryPort {
    
    List<Product> searchAll();

    Product searchBySku(String sku);

    void save(Product product);
    
}