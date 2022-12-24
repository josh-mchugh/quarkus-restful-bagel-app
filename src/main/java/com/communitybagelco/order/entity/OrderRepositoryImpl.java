package com.communitybagelco.order.entity;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.communitybagelco.order.model.Order;
import com.communitybagelco.order.service.model.OrderRequest;
import com.communitybagelco.product.ProductRepository;

import lombok.AllArgsConstructor;

@Transactional
@ApplicationScoped
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    
    private final EntityManager entityManager;
    private final ProductRepository productRepository;

    @Override
    public Order create(OrderRequest request) {
        
        OrderEntity entity = new OrderEntity();
        entity.setTimestamp(LocalDateTime.now());
        
        request.getItems().forEach(item -> {
            productRepository.findById(item.getProductId())
                .ifPresent(productEntity -> {

                    OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
                    orderDetailEntity.setOrder(entity);
                    orderDetailEntity.setProduct(productEntity);
                    orderDetailEntity.setQuantity(item.getQuantity());

                    entity.addOrderDetail(orderDetailEntity);
                });
        }); 

        entityManager.persist(entity);

        return Order.builder()
            .id(entity.getId())
            .timestamp(entity.getTimestamp())
            .build();
    }
}
