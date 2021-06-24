package com.example.ordermanagementserver.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST, value = "/order")
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/order/forward/{orderId}")
    public void changeStatusForward(@PathVariable String orderId){
        orderService.changeStatusForNext(orderId);
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/order/backward/{orderId}")
    public void changeStatusBackward(@PathVariable String orderId){
        orderService.changeStatusForPrevious(orderId);
    }
    @RequestMapping(method = RequestMethod.GET, value ="/orders")
    public List<OrderDTO> getOrderList(){
        return orderService.getOrderList();
    }

    /*@RequestMapping(method = RequestMethod.GET, value = "orders/2")
    public void setAllStatus(){
        orderService.setStatus();
    }*/


}
