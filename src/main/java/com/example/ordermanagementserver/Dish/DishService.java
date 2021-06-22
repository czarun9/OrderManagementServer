package com.example.ordermanagementserver.Dish;

import com.example.ordermanagementserver.Order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishService {
    @Autowired
    DishRepository dishRepository;

    public void addDish(Dish dish) {
        dishRepository.save(dish);
    }

    public Dish getDish(String dishId) {
        return dishRepository.findById(dishId).orElse(null);
    }
}
