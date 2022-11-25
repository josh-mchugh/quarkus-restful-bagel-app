package com.communitybagelco.product.service;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.communitybagelco.product.entity.ProductRepository;
import com.communitybagelco.product.model.Product;

import lombok.AllArgsConstructor;

@ApplicationScoped
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;
    
    @Override
    public List<Product> findAll() {
        
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByIds(Collection<Integer> ids) {
        
        return productRepository.findByIds(ids);
    }
}
