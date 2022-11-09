package com.communitybagelco.product;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {
    
    @Test
    public void whenGetAllThenExpectList() {

        List<Product> expected = List.of(
            Product.builder().name("Plain").build(),
            Product.builder().name("Everything").build(),
            Product.builder().name("Poppy").build(),
            Product.builder().name("Onion").build()
        );

        ProductService service = new ProductServiceImpl();

        Assertions.assertIterableEquals(expected, service.getAll());
    }
}
