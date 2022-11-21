package com.communitybagelco.order;

import java.math.BigDecimal;
import java.util.List;

import com.communitybagelco.product.Product;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@Data
@RegisterForReflection
public class Order {
    
    private Integer id;
    private List<Product> products;
    private BigDecimal total;
}
