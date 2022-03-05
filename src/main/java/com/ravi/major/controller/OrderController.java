package com.ravi.major.controller;

import com.ravi.major.dto.OrderDetail;
import com.ravi.major.dto.responseentity.CartItemResponse;
import com.ravi.major.service.CartServiceImpl;
import com.ravi.major.service.ItemService;
import com.ravi.major.service.OrderItemsServiceImpl;
import com.ravi.major.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderItemsServiceImpl orderDetailService;

    @Autowired
    CartServiceImpl cartService;

    @Autowired
    private ItemService cartItemService;

    @PostMapping("/place-order/{userId}")
    public OrderDetail placeOrder(@PathVariable("userId") int userId) {
        return orderDetailService.placeOrder(userId);
    }
    @DeleteMapping("/all")
    public void deleteAll(){
        orderService.deleteAll();
    }

}
