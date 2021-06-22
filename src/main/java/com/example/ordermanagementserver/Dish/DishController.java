package com.example.ordermanagementserver.Dish;

import com.example.ordermanagementserver.Order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {
    @Autowired
    DishService dishService;

    @RequestMapping(method = RequestMethod.POST, value = "/dish")
    public void addDish(@RequestBody Dish dish) {
        dishService.addDish(dish);
    }

}
