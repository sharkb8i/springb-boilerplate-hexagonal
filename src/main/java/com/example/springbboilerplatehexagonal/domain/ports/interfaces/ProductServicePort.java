package com.example.springbboilerplatehexagonal.domain.ports.interfaces;

import java.util.List;

import com.example.springbboilerplatehexagonal.domain.dtos.ProductDTO;
import com.example.springbboilerplatehexagonal.domain.dtos.StockDTO;

import javassist.NotFoundException;

public interface ProductServicePort {
    
    List<ProductDTO> searchProducts();

    void createProduct(ProductDTO dto);

    void updateStock(String sku, StockDTO dto) throws NotFoundException;
    
}