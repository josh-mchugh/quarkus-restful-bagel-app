package com.communitybagelco.product.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.communitybagelco.product.entity.ProductEntity;
import com.communitybagelco.product.entity.ProductRepository;
import com.communitybagelco.product.model.Product;

public class ProductServiceTest {


    @Test
    public void whenFindAllIsValidThenExpectResults() {
        
        List<ProductEntity> entites = List.of(
            createPlainEntity(),
            createEverythingEntity()
        );

        ProductRepository repository = Mockito.mock(ProductRepository.class);
        Mockito.when(repository.findAll()).thenReturn(entites);

        ProductService service = new ProductServiceImpl(repository);

        List<Product> expected = List.of(
            createPlain(),
            createEverything()
        );

        Assertions.assertEquals(expected, service.findAll());
    }   
    
    @Test
    public void whenFindAllThrowsExpectionExpectException() {

        ProductRepository repository = Mockito.mock(ProductRepository.class);
        Mockito.when(repository.findAll()).thenThrow(NullPointerException.class);

        ProductService service = new ProductServiceImpl(repository);

        Assertions.assertThrowsExactly(NullPointerException.class, () -> service.findAll());
    }

    @Test
    public void whenFindByIdsIsValidThenExpectResults() {

        List<ProductEntity> entities = List.of(
            createPlainEntity()
        );

        ProductRepository repository = Mockito.mock(ProductRepository.class);
        Mockito.when(repository.findByIds(Mockito.anyCollection())).thenReturn(entities);

        ProductService service = new ProductServiceImpl(repository);

        List<Product> expected = List.of(
            createPlain()
        );

        Assertions.assertEquals(expected, service.findByIds(List.of(1)));
    }

    @Test
    public void whenFindByIdThorwsExpectionThenExpectException() {
        
        ProductRepository repository = Mockito.mock(ProductRepository.class);
        Mockito.when(repository.findByIds(Mockito.anyCollection())).thenThrow(NullPointerException.class);

        ProductService service = new ProductServiceImpl(repository);

        Assertions.assertThrowsExactly(NullPointerException.class, () -> service.findByIds(List.of(1)));
    }

    private ProductEntity createPlainEntity() {

        ProductEntity entity = new ProductEntity();
        entity.setName("Plain");

        return entity;
    }

    private Product createPlain() {

        return Product.builder()
            .name("Plain")
            .build();
    }

    private ProductEntity createEverythingEntity() {

        ProductEntity entity = new ProductEntity();
        entity.setName("Everything");

        return entity;
    }

    private Product createEverything() {

        return Product.builder()
            .name("Everything")
            .build();
    }
}
