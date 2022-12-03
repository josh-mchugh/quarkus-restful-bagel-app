package com.communitybagelco.order.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "orders")
@ToString
@RegisterForReflection
public class OrderEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "order")
    private List<OrderDetailEntity> orderDetails = new ArrayList<>();

    public void addOrderDetail(OrderDetailEntity orderDetailEntity) {

        if(orderDetails == null) {

            orderDetails = new ArrayList<>();
        }

        orderDetails.add(orderDetailEntity); 
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof OrderEntity)) return false;
        
        OrderEntity entity = (OrderEntity) o;
        
        return Objects.equals(getId(), entity.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
