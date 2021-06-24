package com.example.ordermanagementserver.OrderPosition;

import com.example.ordermanagementserver.Dish.Dish;
import com.example.ordermanagementserver.Dish.DishService;
import com.example.ordermanagementserver.Order.Order;
import com.example.ordermanagementserver.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderPositionController {
    @Autowired
    OrderPositionService orderPositionService;
    @Autowired
    OrderService orderService;
    @Autowired
    DishService dishService;

    @RequestMapping(method = RequestMethod.POST, value = "/orderposition")
    public void addOrderPosition(@RequestBody OrderPositionDTO orderPositionDTO) {
        OrderPosition orderPosition = new OrderPosition();

        Order order = orderService.getOrder(orderPositionDTO.orderId);
        Dish dish = dishService.getDish(orderPositionDTO.getDishDTO().getId());

        orderPosition.setOrder(order);
        orderPosition.setDish(dish);
        orderPosition.setQuantity(orderPositionDTO.quantity);

        orderPositionService.addOrderPosition(orderPosition);
    }

}
