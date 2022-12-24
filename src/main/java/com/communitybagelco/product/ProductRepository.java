package com.communitybagelco.product;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<ProductEntity> findById(Integer id);
    
    List<ProductEntity> findAll();

    List<ProductEntity> findByIds(Collection<Integer> ids);
}
