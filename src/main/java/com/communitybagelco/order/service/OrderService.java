package com.communitybagelco.order.service;

import com.communitybagelco.order.service.model.OrderRequest;
import com.communitybagelco.order.service.model.OrderResponse;

public interface OrderService {

    OrderResponse createOrder(OrderRequest request);
}
