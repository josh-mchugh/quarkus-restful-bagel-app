package com.communitybagelco.product.service;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.communitybagelco.product.entity.ProductRepository;
import com.communitybagelco.product.model.Product;
import com.communitybagelco.product.model.ProductMapper;

import lombok.AllArgsConstructor;

@ApplicationScoped
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;
    
    @Override
    public List<Product> findAll() {
        
        return ProductMapper.map(productRepository.findAll());
    }

    @Override
    public List<Product> findByIds(Collection<Integer> ids) {
        
        return ProductMapper.map(productRepository.findByIds(ids));
    }
}
