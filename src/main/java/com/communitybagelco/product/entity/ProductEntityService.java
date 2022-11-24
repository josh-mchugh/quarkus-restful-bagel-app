package com.communitybagelco.product.entity;

import java.util.Collection;
import java.util.List;

public interface ProductEntityService {
    
    List<ProductEntity> getAll();

    List<ProductEntity> getByIds(Collection<Integer> ids);
}
