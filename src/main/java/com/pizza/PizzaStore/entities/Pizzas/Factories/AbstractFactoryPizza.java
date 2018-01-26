package com.pizza.PizzaStore.entities.Pizzas.Factories;

import com.pizza.PizzaStore.entities.Pizzas.PizzaBase;
import com.pizza.PizzaStore.entities.ingredients.Cheese;
import com.pizza.PizzaStore.entities.ingredients.Dough;
import com.pizza.PizzaStore.entities.ingredients.Sauce;
import com.pizza.PizzaStore.entities.ingredients.Veggie;

import java.util.List;

public interface AbstractFactoryPizza {
    Cheese createCheese();
    Dough createDough();
    Sauce createSauce();
    List<Veggie> createVeggies(PizzaBase.PIZZA_TYPE pizza_type);
    String getStyleDescription();
}
