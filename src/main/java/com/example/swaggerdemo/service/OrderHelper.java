package com.example.swaggerdemo.service;

import com.example.swaggerdemo.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderHelper {
    public Order getOrder() {
        Order order = new Order();
        order.setOrderId(1234);
        order.setDate("2077-09-05");
        return order;
    }
}
