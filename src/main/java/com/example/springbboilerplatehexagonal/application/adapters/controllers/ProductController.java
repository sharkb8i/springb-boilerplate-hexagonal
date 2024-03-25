package com.example.springbboilerplatehexagonal.application.adapters.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbboilerplatehexagonal.domain.dtos.ProductDTO;
import com.example.springbboilerplatehexagonal.domain.dtos.StockDTO;
import com.example.springbboilerplatehexagonal.domain.ports.interfaces.ProductServicePort;

import javassist.NotFoundException;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductServicePort productServicePort;

    public ProductController(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @PostMapping
    void createProducts(@RequestBody ProductDTO dto) {
        productServicePort.createProduct(dto);
    }

    @GetMapping
    List<ProductDTO> getProducts() {
        return productServicePort.searchProducts();
    }

    @PutMapping(value = "/{sku}")
    void updateStock(@PathVariable String sku, @RequestBody StockDTO dto) throws NotFoundException {
        productServicePort.updateStock(sku, dto);
    }
}