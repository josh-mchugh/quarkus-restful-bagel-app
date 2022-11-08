package com.communitybagelco.product;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {
    
    @Test
    public void whenGetAllThenExpectList() {

        List<Product> expected = List.of(
            new Product().setName("Plain"),
            new Product().setName("Everything"),
            new Product().setName("Poppy"),
            new Product().setName("Onion")
        );

        ProductService service = new ProductServiceImpl();

        Assertions.assertIterableEquals(expected, service.getAll());
    }
}
