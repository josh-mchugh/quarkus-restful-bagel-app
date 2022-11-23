package com.communitybagelco.product;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.jooq.DSLContext;
import org.jooq.generated.tables.Products;

import lombok.AllArgsConstructor;

@ApplicationScoped
@AllArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    

    private final DSLContext dsl;

    @Override
    public List<Product> getAll() {
                
        return dsl.selectFrom(Products.PRODUCTS)
            .fetch()
            .into(Product.class);
    }

    @Override
    public List<Product> getByIds(Collection<Integer> ids) {
        
        return getAll().stream()
            .filter(product -> ids.contains(product.getId()))
            .toList();
    }    
}
