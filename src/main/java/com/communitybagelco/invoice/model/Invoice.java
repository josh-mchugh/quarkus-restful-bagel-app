package com.communitybagelco.invoice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableInvoice.class)
@JsonDeserialize(as = ImmutableInvoice.class)
public abstract class Invoice {
    
    public abstract Integer orderId();
    public abstract LocalDateTime timestamp();
    public abstract BigDecimal total();
    public abstract List<Item> items();

    @Value.Immutable
    public interface Item {

        Integer productId();
        String productName();
        Integer quantity();
        BigDecimal total();
    } 
}
