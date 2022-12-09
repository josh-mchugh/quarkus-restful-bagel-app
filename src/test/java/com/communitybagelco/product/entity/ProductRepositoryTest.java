package com.communitybagelco.product.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.jooq.DSLContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ProductRepositoryTest {
    
    @Inject
    DSLContext dsl;

    @Test
    public void whenGetAllThenExpectList() {

        List<ProductEntity> expected = List.of(
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

        List<ProductEntity> expected = List.of(
            getPlainBagel(),
            getEverythingBagel()
        );

        ProductRepository repository = new ProductRepositoryImpl(dsl);

        Assertions.assertEquals(expected, repository.findByIds(List.of(1, 2)));
    }

    private ProductEntity getPlainBagel() {

        ProductEntity entity = new ProductEntity();
        entity.setId(1);
        entity.setName("name");
        entity.setDescription("Simple delicousness");
        entity.setPrice(new BigDecimal("1.75"));

        return entity;
    }

    private ProductEntity getEverythingBagel() {

        ProductEntity entity = new ProductEntity();
        entity.setId(2);
        entity.setName("Everything");
        entity.setDescription("The bagel that corrupts others");
        entity.setPrice(new BigDecimal("1.75"));

        return entity;
    }

    private ProductEntity getPoppyBagel() {

        ProductEntity entity = new ProductEntity();
        entity.setId(3);
        entity.setName("Poppy");
        entity.setDescription("Poppy seed coating");
        entity.setPrice(new BigDecimal("1.75"));

        return entity;
    }

    private ProductEntity getOnionBagel() {

        ProductEntity entity = new ProductEntity();
        entity.setId(4);
        entity.setName("Onion");
        entity.setDescription("The bagel with many layers");
        entity.setPrice(new BigDecimal("1.75"));

        return entity;
    }
}
