package com.example.ordermanagementserver.OrderPosition;

import com.example.ordermanagementserver.Order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPositionService {
    @Autowired
    OrderPositionRepository orderPositionRepository;

    public void addOrderPosition(OrderPosition orderPosition) {
        orderPositionRepository.save(orderPosition);
    }
}
