package com.pizza.PizzaStore.controller;


import com.pizza.PizzaStore.entities.Pizza;
import com.pizza.PizzaStore.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @RequestMapping("/orderPizza")
    public String orderPizza(@RequestParam(value="pizzaName") String pizzaName) {
        this.pizzaService.savePizza(pizzaName);
        return "Pizza created successfull !!!!";
    }

    @RequestMapping("/getAllPizzas")
    public List <Pizza> getAllPizzas() {
        List <Pizza> pizzas = this.pizzaService.getAllPizzas();
        return pizzas;
    }

   /* @RequestMapping("/createPizzaType")
    public List <Pizza> getAllPizzaType() {
        List <Pizza> pizzas = this.pizzaService.getAllPizzas();
        return pizzas;
    }

    @RequestMapping("/createPizzaType")
    public List <Pizza> createPizzaType() {
        List <Pizza> pizzas = this.pizzaService.getAllPizzas();
        return pizzas;
    }*/


}
