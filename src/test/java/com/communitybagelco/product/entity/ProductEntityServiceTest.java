package com.communitybagelco.product.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.jooq.DSLContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ProductEntityServiceTest {
    
    @Inject
    DSLContext dsl;

    private ProductEntity plain;
    private ProductEntity everything;
    private ProductEntity poppy;
    private ProductEntity onion;

    @BeforeEach
    public void setup() {

        plain = new ProductEntity();
        plain.setId(1);
        plain.setName("Plain");
        plain.setDescription("Simple delicousness");
        plain.setPrice(new BigDecimal("1.75"));

        everything = new ProductEntity();
        everything.setId(2);
        everything.setName("Everything");
        everything.setDescription("The bagel that corrupts others");
        everything.setPrice(new BigDecimal("1.75"));

        poppy = new ProductEntity();
        poppy.setId(3);
        poppy.setName("Poppy");
        poppy.setDescription("Poppy seed coating");
        poppy.setPrice(new BigDecimal("1.75"));

        onion = new ProductEntity();
        onion.setId(4);
        onion.setName("Onion");
        onion.setDescription("The bagel with many layers");
        onion.setPrice(new BigDecimal("1.75"));
    }

    @Test
    public void whenGetAllThenExpectList() {

        //Category category = new Category("Bagels");
        List<ProductEntity> expected = List.of(
            plain,
            everything,
            poppy,
            onion
        );

        ProductRepository repository = new ProductRepositoryImpl(dsl);

        Assertions.assertIterableEquals(expected, repository.getAll());
    }

    @Test
    public void whenGetByIdsThenExpectList() {

        //Category category = new Category("Bagels");
        List<ProductEntity> expected = List.of(
            plain,
            everything
        );

        ProductRepository repository = new ProductRepositoryImpl(dsl);

        Assertions.assertEquals(expected, repository.getByIds(List.of(1, 2)));
    }
}
