package com.example.ordermanagementserver.OrderPosition;

import com.example.ordermanagementserver.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPositionRepository extends JpaRepository<OrderPosition,String> {
}
