package com.communitybagelco.product.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "products")
@ToString
@RegisterForReflection
public class ProductEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;
    
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;
        
        ProductEntity entity = (ProductEntity) o;
        
        return Objects.equals(getId(), entity.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
