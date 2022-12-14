package com.communitybagelco.product.entity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.jooq.DSLContext;

import lombok.AllArgsConstructor;

import static org.jooq.generated.tables.Products.PRODUCTS;

@ApplicationScoped
@AllArgsConstructor
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
    

    private final DSLContext dsl;
    
    @Override
    public Optional<ProductEntity> findById(Integer id) {
        
        return dsl.selectFrom(PRODUCTS)
            .where(PRODUCTS.PRODUCT_ID.eq(id))
            .fetchOptionalInto(ProductEntity.class);
    }

    @Override
    public List<ProductEntity> findAll() {
                
        return dsl.selectFrom(PRODUCTS)
            .fetch()
            .into(ProductEntity.class);
    }

    @Override
    public List<ProductEntity> findByIds(Collection<Integer> ids) {
        
        return dsl.selectFrom(PRODUCTS)
            .where(PRODUCTS.PRODUCT_ID.in(ids))
            .fetch()
            .into(ProductEntity.class);
    }    
}
