package com.communitybagelco.product.service;

import java.util.Collection;
import java.util.List;

import com.communitybagelco.product.model.Product;

public interface ProductService {
    
    List<Product> findAll();
    
    List<Product> findByIds(Collection<Integer> ids);
}
