package com.pizza.PizzaStore;

import com.pizza.PizzaStore.entities.Pizzas.Factories.AbstractFactoryPizza;
import com.pizza.PizzaStore.entities.Pizzas.Factories.FactoryPremPizza;
import com.pizza.PizzaStore.entities.Pizzas.*;
import com.pizza.PizzaStore.entities.ingredients.Ingredient;
import com.pizza.PizzaStore.entities.ingredients.Veggie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryPremiumTest {



    private AbstractFactoryPizza factoryPremPizza = null;
    private double baseTotalCost = 0;
    private static final double COST_VEGGIES_PIZZA_VEGGIE = 10.25f;
    private static final double COST_VEGGIES_PIZZA_FUGGAZZA = 6.0f;
    private static final double COST_VEGGIES_PIZZA_NEAPOLITAN = 8.0f;
    private static final double COST_VEGGIES_PIZZA_MOZZARELLA = 0.0f;
    private static final double COST_EXTRA_PIZZA_VEGGIE = 2.00f;
    private static final double COST_EXTRA_PIZZA_FUGGAZZA = 0f;
    private static final double COST_EXTRA_PIZZA_NEAPOLITAN = 3.00f;
    private static final double COST_EXTRA_PIZZA_MOZZARELLA = 4.00f;
    private static final double COST_CHEESE = 1.50f;
    private static final double COST_DOUGH = 2.50f;
    private static final double COST_SAUCE = 3.50f;
    private static final double COST_BASE = 5.00f;

    @Before
    public void initTest() {
        factoryPremPizza = new FactoryPremPizza();
        //baseTotalCost += COST_CHEESE; CHEESE STILL IS NOT ADDED
        baseTotalCost = COST_DOUGH;
        baseTotalCost += COST_SAUCE;
        baseTotalCost += COST_BASE;
    }

    @Test
    public void testCheeseCost() {
        Ingredient cheese = this.factoryPremPizza.createCheese();
        assertThat(cheese.getCost()).isEqualTo(COST_CHEESE);
    }

    @Test
    public void testDoughCost() {
        Ingredient dough = this.factoryPremPizza.createDough();
        assertThat(dough.getCost()).isEqualTo(COST_DOUGH);
    }

    @Test
    public void testSauceCost() {
        Ingredient sauce = this.factoryPremPizza.createSauce();
        assertThat(sauce.getCost()).isEqualTo(COST_SAUCE);
    }

    @Test
    public void testVeggieCost() {
        List<Veggie> veggies = this.factoryPremPizza.createVeggies(PizzaBase.PIZZA_TYPE.VEGGIE);
        assertThat(veggies.stream().mapToDouble(Ingredient::getCost).sum()).isEqualTo(COST_VEGGIES_PIZZA_VEGGIE);
        veggies = this.factoryPremPizza.createVeggies(PizzaBase.PIZZA_TYPE.FUGAZZA);
        assertThat(veggies.stream().mapToDouble(Ingredient::getCost).sum()).isEqualTo(COST_VEGGIES_PIZZA_FUGGAZZA);
        veggies = this.factoryPremPizza.createVeggies(PizzaBase.PIZZA_TYPE.MOZZARELLA);
        assertThat(veggies.stream().mapToDouble(Ingredient::getCost).sum()).isEqualTo(COST_VEGGIES_PIZZA_MOZZARELLA);
        veggies = this.factoryPremPizza.createVeggies(PizzaBase.PIZZA_TYPE.NEAPOLITAN);
        assertThat(veggies.stream().mapToDouble(Ingredient::getCost).sum()).isEqualTo(COST_VEGGIES_PIZZA_NEAPOLITAN);
    }

    @Test
    public void testBaseTotalCost() {
        double baseTotalCostVeggie = new PizzaVeggie(this.factoryPremPizza).getBaseTotalCost();
        double baseTotalCostFugazza = new PizzaFugazza(this.factoryPremPizza).getBaseTotalCost();
        double baseTotalCostNeapolitan = new PizzaNeapolitan(this.factoryPremPizza).getBaseTotalCost();
        double baseTotalCostMozzarella = new PizzaMozzarella(this.factoryPremPizza).getBaseTotalCost();
        assertThat(baseTotalCostVeggie).isEqualTo(baseTotalCost);
        assertThat(baseTotalCostFugazza).isEqualTo(baseTotalCost);
        assertThat(baseTotalCostNeapolitan).isEqualTo(baseTotalCost);
        assertThat(baseTotalCostMozzarella).isEqualTo(baseTotalCost);
    }

    @Test
    public void testVeggiePizzaPremTotalCost() {
        PizzaBase pizzaBase = new PizzaVeggie(this.factoryPremPizza);
        double totalCost = baseTotalCost;
        totalCost += COST_EXTRA_PIZZA_VEGGIE;
        totalCost += COST_VEGGIES_PIZZA_VEGGIE;
        assertThat(pizzaBase.getTotalCost()).isEqualTo(totalCost);
    }

    @Test
    public void testFuggazzaPizzaPremTotalCost() {
        PizzaBase pizzaBase = new PizzaFugazza(this.factoryPremPizza);
        double totalCost = baseTotalCost;
        totalCost += COST_EXTRA_PIZZA_FUGGAZZA;
        totalCost += COST_VEGGIES_PIZZA_FUGGAZZA;
        assertThat(pizzaBase.getTotalCost()).isEqualTo(totalCost);
    }


    @Test
    public void testMozzarellaPizzaPremTotalCost() {
        PizzaBase pizzaBase = new PizzaMozzarella(this.factoryPremPizza);
        double totalCost = baseTotalCost;
        totalCost += COST_EXTRA_PIZZA_MOZZARELLA;
        totalCost += COST_VEGGIES_PIZZA_MOZZARELLA;
        assertThat(pizzaBase.getTotalCost()).isEqualTo(totalCost);
    }

    @Test
    public void testNeapolitanPizzaPremTotalCost() {
        PizzaBase pizzaBase = new PizzaNeapolitan(this.factoryPremPizza);
        double totalCost = baseTotalCost;
        totalCost += COST_EXTRA_PIZZA_NEAPOLITAN;
        totalCost += COST_VEGGIES_PIZZA_NEAPOLITAN;
        assertThat(pizzaBase.getTotalCost()).isEqualTo(totalCost);
    }

}
