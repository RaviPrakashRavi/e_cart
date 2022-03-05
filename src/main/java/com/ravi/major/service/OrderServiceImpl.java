package com.ravi.major.service;

import com.ravi.major.model.Order;
import com.ravi.major.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class OrderServiceImpl {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserServiceImpl userService;

    public Order createOrder(int userId){
        Order order = orderRepository.getOrderByUserId(userId);
        if(Objects.nonNull(order)){
            return order;
        }
        order = new Order();
        order.setUser(userService.getUserById(userId));
        order.setOrderedDate(new Date());
        return orderRepository.save(order);
    }

    public void deleteOrder(int orderId){
        orderRepository.deleteById(orderId);
    }

    public void deleteAll(){
        orderRepository.deleteAll();
    }
}
