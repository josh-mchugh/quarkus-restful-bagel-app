package com.communitybagelco.product.entity;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.jooq.DSLContext;

import com.communitybagelco.product.model.Product;

import lombok.AllArgsConstructor;

import static org.jooq.generated.tables.Products.PRODUCTS;

@ApplicationScoped
@AllArgsConstructor
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
    

    private final DSLContext dsl;

    @Override
    public List<Product> findAll() {
                
        return dsl.selectFrom(PRODUCTS)
            .fetch()
            .into(Product.class);
    }

    @Override
    public List<Product> findByIds(Collection<Integer> ids) {
        
        return dsl.selectFrom(PRODUCTS)
            .where(PRODUCTS.PRODUCT_ID.in(ids))
            .fetch()
            .into(Product.class);
    }    
}
