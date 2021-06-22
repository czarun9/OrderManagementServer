package com.example.ordermanagementserver.OrderPosition;

import com.example.ordermanagementserver.Dish.Dish;
import com.example.ordermanagementserver.Order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ORDERPOSITION")
public class OrderPosition {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;
    Integer quantity;


    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    Order order;

    @ManyToOne
    @JoinColumn(name = "dish_id", nullable = false)
    Dish dish;


    public OrderPosition(Order order, Dish dish, Integer quantity) {
        this.order = new Order();
        this.dish = new Dish();
        this.quantity = quantity;
    }
}
