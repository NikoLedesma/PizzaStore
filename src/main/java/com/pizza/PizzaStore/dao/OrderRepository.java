package com.pizza.PizzaStore.dao;

import com.pizza.PizzaStore.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long>{
}
