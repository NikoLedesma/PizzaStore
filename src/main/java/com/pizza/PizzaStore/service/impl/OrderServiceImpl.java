package com.pizza.PizzaStore.service.impl;

import com.pizza.PizzaStore.dao.OrderRepository;
import com.pizza.PizzaStore.entities.Order;
import com.pizza.PizzaStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder() {
        Order order = new Order();
        order.setDate(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        order.getDate();
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        for (Order pizza : orderRepository.findAll()) {
            orders.add(pizza);
        }
        return orders;
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findOne(orderId);
    }

    @Override
    public void deleteOrderById(Long number) {
        orderRepository.delete(number);
    }

}
