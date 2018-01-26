package com.pizza.PizzaStore.service.impl;

import com.pizza.PizzaStore.dao.PizzaDao;
import com.pizza.PizzaStore.entities.Pizza;
import com.pizza.PizzaStore.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaDao pizzaDao ;

    @Override
    @Transactional
    public void savePizza(String namePizza) {
        Pizza pizza= new Pizza();
        pizza.setName(namePizza);
        pizzaDao.save(pizza);
    }

    @Override
    @Transactional
    public List<Pizza> getAllPizzas() {
        List<Pizza> pizzas = new ArrayList<>();
        for(Pizza pizza : pizzaDao.findAll()){
            pizzas.add(pizza);
        }
        return pizzas;
    }

}
