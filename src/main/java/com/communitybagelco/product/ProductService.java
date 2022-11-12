package com.communitybagelco.product;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    
    List<Product> getAll();

    List<Product> getByIds(Collection<Integer> ids);
}
