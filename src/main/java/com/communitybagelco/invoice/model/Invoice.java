package com.communitybagelco.invoice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
}
