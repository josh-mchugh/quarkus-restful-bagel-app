package com.communitybagelco.product;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    
    private static final List<Product> PRODUCTS = List.of(
        new Product().setName("Plain"),
        new Product().setName("Everything"),
        new Product().setName("Poppy"),
        new Product().setName("Onion")
    );

    @Override
    public List<Product> getAll() {
        
        return PRODUCTS;
    }
}
