package com.example.springbboilerplatehexagonal.infra.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springbboilerplatehexagonal.domain.adapters.services.OrderServiceImpl;
import com.example.springbboilerplatehexagonal.domain.ports.interfaces.ProductServicePort;
import com.example.springbboilerplatehexagonal.domain.ports.repositories.ProductRepositoryPort;

@Configuration
public class BeanConfiguration {
    
    @Bean
    ProductServicePort productService(ProductRepositoryPort productRepositoryPort) {
        return new OrderServiceImpl(productRepositoryPort);
    }
}