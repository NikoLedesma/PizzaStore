package com.pizza.PizzaStore;

import com.pizza.PizzaStore.entities.Order;
import com.pizza.PizzaStore.service.OrderService;
import org.hibernate.sql.ordering.antlr.OrderByAliasResolver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaStoreOrderServiceTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void testCreateOrder(){
      Order order = orderService.createOrder();
      assertThat(order).isNotNull();
      orderService.deleteOrderById(order.getNumber());
    }

    @Test
    public void testGetOrderById(){
        Order order = orderService.createOrder();
        Order findedOrder = orderService.getOrderById(order.getNumber());
        assertThat(findedOrder).isNotNull();
        assertThat(findedOrder).isEqualTo(order);
        orderService.deleteOrderById(findedOrder.getNumber());
    }

    @Test
    public  void testGetAllOrders(){
        Order orderA = orderService.createOrder();
        Order orderB = orderService.createOrder();
        assertThat(orderService.getAllOrders()).hasSize(2);
        orderService.deleteOrderById(orderA.getNumber());
        orderService.deleteOrderById(orderB.getNumber());
    }

}
