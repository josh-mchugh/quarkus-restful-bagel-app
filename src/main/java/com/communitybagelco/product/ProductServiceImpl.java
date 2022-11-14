package com.communitybagelco.product;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.communitybagelco.category.Category;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    
    private static final Category BAGEL_CATEGORY = new Category("Bagels");

    private static final List<Product> PRODUCTS = List.of(
        Product.builder().id(1).name("Plain").price(1.75D).category(BAGEL_CATEGORY).build(),
        Product.builder().id(2).name("Everything").price(1.75D).category(BAGEL_CATEGORY).build(),
        Product.builder().id(3).name("Poppy").price(1.75D).category(BAGEL_CATEGORY).build(),
        Product.builder().id(4).name("Onion").price(1.75D).category(BAGEL_CATEGORY).build()
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
