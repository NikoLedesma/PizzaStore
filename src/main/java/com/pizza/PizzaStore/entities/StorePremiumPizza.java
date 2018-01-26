package com.pizza.PizzaStore.entities;

import com.pizza.PizzaStore.entities.Pizzas.Factories.AbstractFactoryPizza;
import com.pizza.PizzaStore.entities.Pizzas.Factories.FactoryPremPizza;
import com.pizza.PizzaStore.entities.Pizzas.PizzaBase;
import com.pizza.PizzaStore.entities.Pizzas.PizzaBase.PIZZA_TYPE;
import com.pizza.PizzaStore.entities.Pizzas.PizzaFugazza;
import com.pizza.PizzaStore.entities.Pizzas.PizzaVeggie;

public class StorePremiumPizza implements StorePizza {


    @Override
    public PizzaBase orderPizza(PIZZA_TYPE pizza_type) {
        AbstractFactoryPizza factoryPremPizza= new FactoryPremPizza();
        PizzaBase pizza = null;
        if(pizza_type ==PIZZA_TYPE.VEGGIE){
            pizza = new PizzaVeggie(factoryPremPizza);
        }else if(pizza_type ==PIZZA_TYPE.FUGAZZA){
            pizza = new PizzaFugazza(factoryPremPizza);
        }


        return pizza  ;
    }
}
