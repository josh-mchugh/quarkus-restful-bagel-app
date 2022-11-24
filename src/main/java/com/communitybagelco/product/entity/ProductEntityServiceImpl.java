package com.communitybagelco.product.entity;

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
public class ProductEntityServiceImpl implements ProductEntityService {
    

    private final DSLContext dsl;

    @Override
    public List<ProductEntity> getAll() {
                
        return dsl.selectFrom(Products.PRODUCTS)
            .fetch()
            .into(ProductEntity.class);
    }

    @Override
    public List<ProductEntity> getByIds(Collection<Integer> ids) {
        
        return dsl.selectFrom(Products.PRODUCTS)
            .where(Products.PRODUCTS.PRODUCT_ID.in(ids))
            .fetch()
            .into(ProductEntity.class);
    }    
}
