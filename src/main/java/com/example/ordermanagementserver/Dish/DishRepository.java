package com.example.ordermanagementserver.Dish;

import com.example.ordermanagementserver.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish,String> {
}
