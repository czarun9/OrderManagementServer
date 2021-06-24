package com.example.ordermanagementserver.Order;

import com.example.ordermanagementserver.Dish.Dish;
import com.example.ordermanagementserver.Dish.DishDTO;
import com.example.ordermanagementserver.Dish.DishRepository;
import com.example.ordermanagementserver.OrderPosition.OrderPosition;
import com.example.ordermanagementserver.OrderPosition.OrderPositionDTO;
import com.example.ordermanagementserver.OrderPosition.OrderPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderPositionRepository orderPositionRepository;
    @Autowired
    DishRepository dishRepository;


    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getOrder(String orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public void changeStatusForNext(String orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order.getStatus().equals("Przyjęto do realizacji")) {
            order.setStatus("W trakcie realizacji");
        } else if (order.getStatus().equals("W trakcie realizacji")) {
            order.setStatus("Do odbioru");
        }
        orderRepository.save(order);
    }

    public void changeStatusForPrevious(String orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order.getStatus().equals("Do odbioru")) {
            order.setStatus("W trakcie realizacji");
        } else if (order.getStatus().equals("W trakcie realizacji")) {
            order.setStatus("Przyjęto do realizacji");
        }
        orderRepository.save(order);
    }

    public List<OrderDTO> getOrderList() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> ordersDTO = new ArrayList<>();
        for (Order order : orders) {
            OrderDTO orderDTO = new OrderDTO();

            orderDTO.setId(order.getId());
            orderDTO.setStatus(order.getStatus());
            orderDTO.setTableNo(order.getTableNo());
            List<OrderPosition> orderPositions = orderPositionRepository.findByOrder(order);
            List<OrderPositionDTO> orderPositionDTOList = new ArrayList<>();
            for (OrderPosition orderPosition : orderPositions) {
                OrderPositionDTO orderPositionDTO = new OrderPositionDTO();

                DishDTO dishDTO = new DishDTO();
                dishDTO.setName(orderPosition.getDish().getName());
                dishDTO.setType(orderPosition.getDish().getType());
                dishDTO.setId(orderPosition.getDish().getId());
                orderPositionDTO.setDishDTO(dishDTO);
                orderPositionDTO.setQuantity(orderPosition.getQuantity());
                orderPositionDTOList.add(orderPositionDTO);
            }
            orderDTO.setOrderPositionDTOList(orderPositionDTOList);
            ordersDTO.add(orderDTO);
        }

        return ordersDTO;
    }

    public void setStatus() {
        List<Order> orders = orderRepository.findAll();
        for (Order order : orders) {
            order.setStatus("Przyjęto do realizacji");
            orderRepository.save(order);
        }
    }
}
