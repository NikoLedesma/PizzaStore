package com.pizza.PizzaStore.entities.Pizzas;

import com.pizza.PizzaStore.entities.Pizzas.Factories.AbstractFactoryPizza;
import com.pizza.PizzaStore.entities.ingredients.Ingredient;

public class PizzaNeapolitan extends PizzaBase {

    private static final String DESCRIPTION = "NEAPOLITAN PIZZA";

    public PizzaNeapolitan(AbstractFactoryPizza abstractFactoryPizza) {
        super(abstractFactoryPizza);
        this.extraCost = 3.00f;
        veggies = abstractFactoryPizza.createVeggies(PIZZA_TYPE.NEAPOLITAN);
    }

    @Override
    public String getDescription() {
        return DESCRIPTION + " " + style;
    }

    @Override
    public double getTotalCost() {
        double totalCost = getBaseTotalCost() ;
        totalCost += extraCost;
        totalCost += veggies.stream().mapToDouble(Ingredient::getCost).sum();
        return totalCost;
    }
}
