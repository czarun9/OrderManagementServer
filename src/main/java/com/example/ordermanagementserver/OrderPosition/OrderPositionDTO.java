package com.example.ordermanagementserver.OrderPosition;

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
    String dishId;
    Integer quantity;
}
