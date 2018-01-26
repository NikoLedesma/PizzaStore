package com.pizza.PizzaStore.controller;

import com.pizza.PizzaStore.entities.Order;
import com.pizza.PizzaStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST, value = "/createOrder")
    public Order createOrder() {
        return this.orderService.createOrder();
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List <Order> getOrders() {
        return this.orderService.getAllOrders();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return this.orderService.getOrderById(orderId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{orderId}")
    public void deleteById(@PathVariable Long orderId) {
        this.orderService.deleteOrderById(orderId);
    }


}
