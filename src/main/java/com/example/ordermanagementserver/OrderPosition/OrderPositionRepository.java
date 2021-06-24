package com.example.ordermanagementserver.OrderPosition;

import com.example.ordermanagementserver.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderPositionRepository extends JpaRepository<OrderPosition, String> {
    List<OrderPosition> findByOrder(Order order);
}
