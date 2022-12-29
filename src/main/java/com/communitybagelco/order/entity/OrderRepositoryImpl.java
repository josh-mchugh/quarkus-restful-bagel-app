package com.communitybagelco.order.entity;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.communitybagelco.order.service.model.ImmutableOrderResponse;
import com.communitybagelco.order.service.model.OrderRequest;
import com.communitybagelco.order.service.model.OrderResponse;
import com.communitybagelco.product.ProductRepository;

import lombok.AllArgsConstructor;

@Transactional
@ApplicationScoped
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    
    private final EntityManager entityManager;
    private final ProductRepository productRepository;

    @Override
    public OrderResponse create(OrderRequest request) {
        
        OrderEntity entity = new OrderEntity();
        entity.setTimestamp(LocalDateTime.now());
        
        request.items().forEach(item -> {
            productRepository.findById(item.productId())
                .ifPresent(productEntity -> {

                    OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
                    orderDetailEntity.setOrder(entity);
                    orderDetailEntity.setProduct(productEntity);
                    orderDetailEntity.setQuantity(item.quantity());

                    entity.addOrderDetail(orderDetailEntity);
                });
        }); 

        entityManager.persist(entity);

        return ImmutableOrderResponse.builder()
            .orderId(entity.getId())
            .build();
    }
}
