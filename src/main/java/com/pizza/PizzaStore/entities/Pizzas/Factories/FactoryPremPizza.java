package com.pizza.PizzaStore.entities.Pizzas.Factories;

import com.pizza.PizzaStore.entities.Pizzas.PizzaBase;
import com.pizza.PizzaStore.entities.Pizzas.PizzaBase.PIZZA_TYPE;
import com.pizza.PizzaStore.entities.ingredients.*;

import java.util.ArrayList;
import java.util.List;

public class FactoryPremPizza implements AbstractFactoryPizza {
    private static final String PIZZA_FACTORY_STYLE = "PREMIUM";

    @Override
    public Cheese createCheese() {
        return new CheesePremium();
    }

    @Override
    public Dough createDough() {
        return new DoughPremium();
    }

    @Override
    public Sauce createSauce() {
        return new SaucePremium();
    }

    @Override
    public List<Veggie> createVeggies(PizzaBase.PIZZA_TYPE pizza_type) {
        List<Veggie> veggies = new ArrayList<Veggie>();
        if (pizza_type == PIZZA_TYPE.VEGGIE){
            veggies.add(new VeggieOrganicBroccoli());
            veggies.add(new VeggieOrganicLeeks());
            veggies.add(new VeggieOrganicSpinach());
        }else if(pizza_type == PIZZA_TYPE.FUGAZZA){
            veggies.add(new VeggieOrganicOnion());
            veggies.add(new VeggieOrganicOnion());
        }else if(pizza_type == PIZZA_TYPE.NEAPOLITAN){
            veggies.add(new VeggieOrganicTomato());
            veggies.add(new VeggieOrganicTomato());
            veggies.add(new VeggieOrganicTomato());
            veggies.add(new VeggieOrganicTomato());
        }
        return veggies;
    }

    @Override
    public String getStyleDescription() {
        return PIZZA_FACTORY_STYLE;
    }
}
