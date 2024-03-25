package com.example.springbboilerplatehexagonal.domain;

import java.util.UUID;

import com.example.springbboilerplatehexagonal.domain.dtos.ProductDTO;

public class Product {
    
    private UUID code;
    private String sku;
    private String name;
    private Double price;
    private Double quantity;

    public Product() {

    }

    public Product(UUID code, String sku, String name, Double price, Double quantity) {
        this.code = code;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public UUID getCode() { return code; }

    public String getSku() { return sku; }

    public String getName() { return name; }

    public Double getPrice() { return price; }

    public Double getQuantity() { return quantity; }

    public Product(ProductDTO dto) {
        this.sku = dto.getSku();
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.quantity = dto.getQuantity();
    }

    public void updateStock(double quantity) { this.quantity = quantity; }

    public ProductDTO toProductDTO() {
        return new ProductDTO(this.sku, this.name, this.price, this.quantity);
    }
}