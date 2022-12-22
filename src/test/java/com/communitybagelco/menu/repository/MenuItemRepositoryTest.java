package com.communitybagelco.menu.repository;

import javax.inject.Inject;

import org.jooq.DSLContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MenuItemRepositoryTest {
    
    @Inject
    DSLContext dsl;

    @Test
    public void whenFindAllExpectNotNull() {

        MenuItemRepository repository = new MenuItemRepositoryImpl(dsl);

        Assertions.assertNotNull(repository.findAll());
    }

    @Test
    public void whenFindAllExpectNotEmpty() {

        MenuItemRepository repository = new MenuItemRepositoryImpl(dsl);

        Assertions.assertFalse(repository.findAll().isEmpty());
    }
}
