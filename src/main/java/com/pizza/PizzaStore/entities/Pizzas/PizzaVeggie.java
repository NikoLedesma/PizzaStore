package com.pizza.PizzaStore.entities.Pizzas;

import com.pizza.PizzaStore.entities.Pizzas.Factories.AbstractFactoryPizza;
import com.pizza.PizzaStore.entities.ingredients.Ingredient;
import static com.pizza.PizzaStore.entities.Pizzas.PizzaBase.PIZZA_TYPE.VEGGIE;

public class PizzaVeggie extends PizzaBase {


    private static final String DESCRIPTION = "VEGGIE PIZZA";
    public PizzaVeggie(AbstractFactoryPizza abstractFactoryPizza) {
        super(abstractFactoryPizza);
        veggies = abstractFactoryPizza.createVeggies(VEGGIE);
        this.extraCost = 2.00f;
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
