package com.communitybagelco.product.entity;

import java.util.Collection;
import java.util.List;

import com.communitybagelco.product.model.Product;

public interface ProductRepository {
    
    List<Product> findAll();

    List<Product> findByIds(Collection<Integer> ids);
}
