package com.example.ordermanagementserver.OrderPosition;

import com.example.ordermanagementserver.Dish.Dish;
import com.example.ordermanagementserver.Dish.DishDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderPositionDTO {
    String orderId;
    DishDTO dishDTO;
    Integer quantity;


}
