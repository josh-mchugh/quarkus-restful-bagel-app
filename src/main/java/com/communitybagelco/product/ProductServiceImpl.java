package com.communitybagelco.product;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.communitybagelco.category.Category;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    
    private static final Category BAGEL_CATEGORY = new Category("Bagels");

    private final List<Product> PRODUCTS;

    public ProductServiceImpl() {

        Product plain = new Product();
        plain.setId(1);
        plain.setName("Plain");
        plain.setPrice(new BigDecimal("1.75"));

        Product everything = new Product();
        everything.setId(2);
        everything.setName("Everything");
        everything.setPrice(new BigDecimal("1.75"));

        Product poppy = new Product();
        poppy.setId(3);
        poppy.setName("Poppy");
        poppy.setPrice(new BigDecimal("1.75"));

        Product onion = new Product();
        onion.setId(4);
        onion.setName("Onion");
        onion.setPrice(new BigDecimal("1.75"));

        PRODUCTS = List.of(
            plain,
            everything,
            poppy,
            onion
        );
    }

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
