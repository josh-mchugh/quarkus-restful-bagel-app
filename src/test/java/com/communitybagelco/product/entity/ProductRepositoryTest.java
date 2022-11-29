package com.communitybagelco.product.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.jooq.DSLContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.product.model.Product;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ProductRepositoryTest {
    
    @Inject
    DSLContext dsl;

    @Test
    public void whenGetAllThenExpectList() {

        List<Product> expected = List.of(
            getPlainBagel(),
            getEverythingBagel(),
            getPoppyBagel(),
            getOnionBagel()
        );

        ProductRepository repository = new ProductRepositoryImpl(dsl);

        Assertions.assertIterableEquals(expected, repository.findAll());
    }

    @Test
    public void whenGetByIdsThenExpectList() {

        List<Product> expected = List.of(
            getPlainBagel(),
            getEverythingBagel()
        );

        ProductRepository repository = new ProductRepositoryImpl(dsl);

        Assertions.assertEquals(expected, repository.findByIds(List.of(1, 2)));
    }

    private Product getPlainBagel() {

        return Product.builder()
            .id(1)
            .name("Plain")
            .description("Simple delicousness")
            .price(new BigDecimal("1.75"))
            .build();
    }

    private Product getEverythingBagel() {

        return Product.builder()
            .id(2)
            .name("Everything")
            .description("The bagel that corrupts others")
            .price(new BigDecimal("1.75"))
            .build();
    }

    private Product getPoppyBagel() {

        return Product.builder()
            .id(3)
            .name("Poppy")
            .description("Poppy seed coating")
            .price(new BigDecimal("1.75"))
            .build();
    }

    private Product getOnionBagel() {

        return Product.builder()
            .id(4)
            .name("Onion")
            .description("The bagel with many layers")
            .price(new BigDecimal("1.75"))
            .build();
    }
}
