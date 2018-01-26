package com.pizza.PizzaStore;

import com.pizza.PizzaStore.controller.PizzaController;
import com.pizza.PizzaStore.entities.Pizza;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaStoreApplicationTests {


	@Autowired
	private PizzaController pizzaController;

	@Test
	public void contextLoads() {
		assertThat(pizzaController).isNotNull();
		pizzaController.orderPizza("Veggie");
		pizzaController.orderPizza("Cheesse");
		pizzaController.orderPizza("Neapolitan");
		List<Pizza> pizzaList = pizzaController.getAllPizzas();
		Pizza veggiePizza = pizzaList.get(0);
		assertThat(pizzaList).hasSize(3);
		assertThat(pizzaList).filteredOn("name","Veggie").containsOnly(veggiePizza);
	}

}
