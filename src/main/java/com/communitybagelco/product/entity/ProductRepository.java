package com.communitybagelco.product.entity;

import java.util.Collection;
import java.util.List;

public interface ProductRepository {
    
    List<ProductEntity> findAll();

    List<ProductEntity> findByIds(Collection<Integer> ids);
}
