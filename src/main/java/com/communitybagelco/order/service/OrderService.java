package com.communitybagelco.order.service;

import com.communitybagelco.order.model.Order;
import com.communitybagelco.order.resource.model.OrderBody;

public interface OrderService {

    Order createOrder(OrderBody request);
}
