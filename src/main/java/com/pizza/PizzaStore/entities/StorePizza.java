package com.pizza.PizzaStore.entities;

import com.pizza.PizzaStore.entities.Pizzas.PizzaBase;
import com.pizza.PizzaStore.entities.Pizzas.PizzaBase.PIZZA_TYPE;

public interface StorePizza {
    PizzaBase orderPizza(PIZZA_TYPE pizza_type);
}
