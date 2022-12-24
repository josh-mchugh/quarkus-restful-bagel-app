package com.communitybagelco.product;

import java.math.BigDecimal;
import java.util.Collections;
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
    public void whenFindByIdIsValidThenExpectEntity() {
        
        ProductEntity expected = getPlainBagel();

        ProductRepository repository = new ProductRepositoryImpl(dsl);

        Assertions.assertEquals(expected, repository.findById(1).get());
    }

    @Test
    public void whenFindByIdHasNullParamThenExpectEmpty() {

        ProductRepository repository = new ProductRepositoryImpl(dsl);

        Assertions.assertTrue(repository.findById(null).isEmpty());
    }

    @Test
    public void whenFindByIdHasNoExistingIdThenEmpty() {

        ProductRepository repository = new ProductRepositoryImpl(dsl);

        Assertions.assertTrue(repository.findById(Integer.MAX_VALUE).isEmpty());
    }

    @Test
    public void whenFindAllThenExpectList() {

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
    public void whenFindByIdsThenExpectList() {

        List<ProductEntity> expected = List.of(
            getPlainBagel(),
            getEverythingBagel()
        );

        ProductRepository repository = new ProductRepositoryImpl(dsl);

        Assertions.assertEquals(expected, repository.findByIds(List.of(1, 2)));
    }

    @Test
    public void whenFindByIdsHasEmptyCollectionThenExpectEmptyList() {

        ProductRepository repository = new ProductRepositoryImpl(dsl);

        Assertions.assertEquals(Collections.emptyList(), repository.findByIds(Collections.emptyList()));
    }

    @Test
    public void whenFindByIdsHasNullThenExpectEmptyList() {

        ProductRepository repository = new ProductRepositoryImpl(dsl);

        Assertions.assertEquals(Collections.emptyList(), repository.findByIds(null));
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
