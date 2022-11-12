package com.communitybagelco.product;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    
    private static final List<Product> PRODUCTS = List.of(
        Product.builder().id(1).name("Plain").build(),
        Product.builder().id(2).name("Everything").build(),
        Product.builder().id(3).name("Poppy").build(),
        Product.builder().id(4).name("Onion").build()
    );

    @Override
    public List<Product> getAll() {
        
        return PRODUCTS;
    }

    @Override
    public List<Product> getByIds(Collection<Integer> ids) {
        
        return PRODUCTS.stream()
            .filter(product -> ids.contains(product.getId()))
            .toList();
    }    
}
