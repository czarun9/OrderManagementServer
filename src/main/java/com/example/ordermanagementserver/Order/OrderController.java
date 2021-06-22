package com.example.ordermanagementserver.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST, value = "/order")
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

}
