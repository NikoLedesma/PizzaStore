package com.pizza.PizzaStore.dao;

import com.pizza.PizzaStore.entities.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaDao extends CrudRepository<Pizza,Integer> {

}
