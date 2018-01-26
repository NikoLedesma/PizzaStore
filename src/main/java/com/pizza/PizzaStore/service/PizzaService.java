package com.pizza.PizzaStore.service;

import com.pizza.PizzaStore.entities.Pizza;
import java.util.List;

public interface PizzaService {
    void savePizza(String namePizza);
    List<Pizza> getAllPizzas();
}
