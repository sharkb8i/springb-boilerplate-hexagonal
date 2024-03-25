package com.example.springbboilerplatehexagonal.domain.adapters.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.springbboilerplatehexagonal.domain.Product;
import com.example.springbboilerplatehexagonal.domain.dtos.ProductDTO;
import com.example.springbboilerplatehexagonal.domain.dtos.StockDTO;
import com.example.springbboilerplatehexagonal.domain.ports.interfaces.ProductServicePort;
import com.example.springbboilerplatehexagonal.domain.ports.repositories.ProductRepositoryPort;

import javassist.NotFoundException;

public class OrderServiceImpl implements ProductServicePort {
    
    private final ProductRepositoryPort productRepo;

    public OrderServiceImpl(ProductRepositoryPort productRepo) { this.productRepo = productRepo; }

    @Override
    public void createProduct(ProductDTO dto) {
        Product product = new Product(dto);
        this.productRepo.save(product);
    }

    @Override
    public void updateStock(String sku, StockDTO dto) throws NotFoundException {
        Product product = this.productRepo.searchBySku(sku);

        if (Objects.isNull(product))
            throw new NotFoundException("Product not found");
        
        product.updateStock(dto.getQuantity());

        this.productRepo.save(product);
    }

    @Override
    public List<ProductDTO> searchProducts() {
        List<Product> products = this.productRepo.searchAll();
        List<ProductDTO> dtos = products.stream().map(Product::toProductDTO).collect(Collectors.toList());
        return dtos;
    }
}