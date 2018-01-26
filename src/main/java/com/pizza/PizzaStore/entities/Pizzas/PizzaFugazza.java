package com.pizza.PizzaStore.entities.Pizzas;

import com.pizza.PizzaStore.entities.Pizzas.Factories.AbstractFactoryPizza;
import com.pizza.PizzaStore.entities.ingredients.Ingredient;

public class PizzaFugazza extends PizzaBase {

    private static final String DESCRIPTION = "FUGAZZA PIZZA";

    public PizzaFugazza(AbstractFactoryPizza abstractFactoryPizza) {
        super(abstractFactoryPizza);
        veggies = abstractFactoryPizza.createVeggies(PIZZA_TYPE.FUGAZZA);
    }

    @Override
    public String getDescription() {
        return DESCRIPTION + " " + style;
    }

    @Override

    public double getTotalCost() {
        double totalCost = getBaseTotalCost();
        totalCost += extraCost;
        totalCost += veggies.stream().mapToDouble(Ingredient::getCost).sum();
        return totalCost;
    }

}
