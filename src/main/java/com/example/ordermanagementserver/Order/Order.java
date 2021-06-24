package com.example.ordermanagementserver.Order;

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
@Table(name="ORDER_DOCUMENT")
public class Order {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;
    Integer tableNo;
    String status;

    @OneToMany
    List<OrderPosition> orderPositionList;


    public Order(Integer tableNo) {
        this.tableNo = tableNo;
        this.orderPositionList = new ArrayList<OrderPosition>();
        this.status = "Przyjęto do realizacji";
    }

}
