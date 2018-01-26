package com.pizza.PizzaStore.entities.Pizzas;

import com.pizza.PizzaStore.entities.Pizzas.Factories.AbstractFactoryPizza;
import com.pizza.PizzaStore.entities.ingredients.Dough;
import com.pizza.PizzaStore.entities.ingredients.Sauce;
import com.pizza.PizzaStore.entities.ingredients.Veggie;

import java.util.List;

abstract public class PizzaBase {


    public enum PIZZA_TYPE {
        FUGAZZA,
        MOZZARELLA,
        NEAPOLITAN,
        VEGGIE
    }

    String description;
    Dough dough;
    Sauce sauce;
    static final double baseCost = 5.00;
    double extraCost = 0.00f;
    String style = "";
    List<Veggie> veggies;

    public abstract String getDescription();

    public abstract double getTotalCost();

    public double getBaseTotalCost(){
        double totalCost = baseCost;
        totalCost += sauce.getCost();
        totalCost += dough.getCost();
        return totalCost;
    }

    PizzaBase(AbstractFactoryPizza abstractFactoryPizza) {
        style = abstractFactoryPizza.getStyleDescription();
        sauce = abstractFactoryPizza.createSauce();
        dough = abstractFactoryPizza.createDough();
    }

}
