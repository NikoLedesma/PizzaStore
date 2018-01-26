package com.pizza.PizzaStore.service;

import com.pizza.PizzaStore.entities.Order;

import java.util.List;

public interface OrderService {

    Order createOrder();
    List<Order> getAllOrders();
    Order getOrderById(Long orderId);
    void deleteOrderById(Long number);

}
