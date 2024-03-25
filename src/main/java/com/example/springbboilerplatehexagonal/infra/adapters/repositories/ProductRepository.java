package com.example.springbboilerplatehexagonal.infra.adapters.repositories;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.springbboilerplatehexagonal.domain.Product;
import com.example.springbboilerplatehexagonal.domain.ports.repositories.ProductRepositoryPort;
import com.example.springbboilerplatehexagonal.infra.adapters.entities.ProductEntity;

@Component
public class ProductRepository implements ProductRepositoryPort {

    private final SpringProductRepository springProductRepository;

    public ProductRepository(SpringProductRepository springProductRepository) {
        this.springProductRepository = springProductRepository;
    }

    @Override
    public List<Product> searchAll() {
        List<ProductEntity> entities = this.springProductRepository.findAll();
        return entities.stream().map(ProductEntity::toProduct).collect(Collectors.toList());
    }

    @Override
    public Product searchBySku(String sku) {
        Optional<ProductEntity> entity = this.springProductRepository.findBySku(sku);

        if (entity.isPresent())
            return entity.get().toProduct();
        
        throw new RuntimeException("Product not exists");
    }

    @Override
    public void save(Product product) {
        ProductEntity entity;
        if (Objects.isNull(product.getCode()))
            entity = new ProductEntity(product);
        else {
            entity = this.springProductRepository.findById(product.getCode()).get();
            entity.update(product);
        }

        this.springProductRepository.save(entity);
    }
}