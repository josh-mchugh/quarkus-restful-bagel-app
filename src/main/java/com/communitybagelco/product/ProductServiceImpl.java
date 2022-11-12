package com.communitybagelco.product;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    
    private static final List<Product> PRODUCTS = List.of(
        Product.builder().id(1).name("Plain").price(1.75D).build(),
        Product.builder().id(2).name("Everything").price(1.75D).build(),
        Product.builder().id(3).name("Poppy").price(1.75D).build(),
        Product.builder().id(4).name("Onion").price(1.75D).build()
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
