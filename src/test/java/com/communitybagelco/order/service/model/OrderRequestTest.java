package com.communitybagelco.order.service.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO: Add Tests
public class OrderRequestTest {
 
    @Test
    public void whenRequestBuilderSetsNullItemsThenExpectExpection() {

        ImmutableOrderRequest.Builder builder = ImmutableOrderRequest.builder();

        Assertions.assertThrows(NullPointerException.class, () -> builder.items(null));
    }

    @Test
    public void whenRequesBuilderAddsNullItemThenExpectException() {

        ImmutableOrderRequest.Builder builder = ImmutableOrderRequest.builder();

        Assertions.assertThrows(NullPointerException.class, () -> builder.addItems((OrderRequest.Item) null));
    }

    @Test
    public void whenRequestBuilderAddsNullItemsThenExpectException() {

        ImmutableOrderRequest.Builder builder = ImmutableOrderRequest.builder();

        Assertions.assertThrows(NullPointerException.class, () -> builder.addAllItems(null));
    }
}
