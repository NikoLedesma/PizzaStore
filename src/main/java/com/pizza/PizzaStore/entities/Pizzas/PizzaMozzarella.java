package com.pizza.PizzaStore.entities.Pizzas;

import com.pizza.PizzaStore.entities.Pizzas.Factories.AbstractFactoryPizza;
import com.pizza.PizzaStore.entities.ingredients.Ingredient;

public class PizzaMozzarella extends PizzaBase{

    private static final String DESCRIPTION = "MOZZARELLA PIZZA";

    public PizzaMozzarella(AbstractFactoryPizza abstractFactoryPizza){
        super(abstractFactoryPizza);
        extraCost = 4.00f;
        veggies = abstractFactoryPizza.createVeggies(PIZZA_TYPE.MOZZARELLA);
    }

    @Override
    public String getDescription() {
        return DESCRIPTION + " " + style;
    }


    @Override
    public double getTotalCost() {
        double totalCost = getBaseTotalCost();
        totalCost += this.extraCost;
        totalCost += veggies.stream().mapToDouble(Ingredient::getCost).sum();
        return totalCost;
    }
}
