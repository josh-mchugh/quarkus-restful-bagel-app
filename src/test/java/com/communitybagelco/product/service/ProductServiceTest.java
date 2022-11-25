package com.communitybagelco.product.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.communitybagelco.product.entity.ProductRepository;
import com.communitybagelco.product.model.Product;

public class ProductServiceTest {


    @Test
    public void whenFindAllIsValidThenExpectResults() {
        
        List<Product> expected = List.of(
            Product.builder().name("Plain").build(),
            Product.builder().name("Everyting").build()
        );

        ProductRepository repository = Mockito.mock(ProductRepository.class);
        Mockito.when(repository.findAll()).thenReturn(expected);

        ProductService service = new ProductServiceImpl(repository);

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

        List<Product> expected = List.of(
            Product.builder().id(1).name("Plain").build()
        );

        ProductRepository repository = Mockito.mock(ProductRepository.class);
        Mockito.when(repository.findByIds(Mockito.anyCollection())).thenReturn(expected);

        ProductService service = new ProductServiceImpl(repository);

        Assertions.assertEquals(expected, service.findByIds(List.of(1)));
    }

    @Test
    public void whenFindByIdThorwsExpectionThenExpectException() {
        
        ProductRepository repository = Mockito.mock(ProductRepository.class);
        Mockito.when(repository.findByIds(Mockito.anyCollection())).thenThrow(NullPointerException.class);

        ProductService service = new ProductServiceImpl(repository);

        Assertions.assertThrowsExactly(NullPointerException.class, () -> service.findByIds(List.of(1)));
    }
}
