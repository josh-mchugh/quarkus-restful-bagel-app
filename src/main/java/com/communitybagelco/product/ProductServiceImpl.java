package com.communitybagelco.product;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    
    private static final List<Product> PRODUCTS = List.of(
        Product.builder().name("Plain").build(),
        Product.builder().name("Everything").build(),
        Product.builder().name("Poppy").build(),
        Product.builder().name("Onion").build()
    );

    @Override
    public List<Product> getAll() {
        
        return PRODUCTS;
    }
}
