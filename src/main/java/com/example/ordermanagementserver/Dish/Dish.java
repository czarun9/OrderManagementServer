package com.example.ordermanagementserver.Dish;


import com.example.ordermanagementserver.OrderPosition.OrderPosition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "DISH")
public class Dish {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;
    String name;
    Double price;
    String type;

    @OneToMany
    List<OrderPosition> orderPositionList;

    public Dish(String name, Double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.orderPositionList = new ArrayList<>();
    }
}
