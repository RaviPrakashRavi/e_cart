package com.ravi.major.service;

import com.ravi.major.dto.OrderDetail;
import com.ravi.major.dto.responseentity.ProceedItemResponse;
import com.ravi.major.enums.OrderStatus;
import com.ravi.major.exception.ProductException;
import com.ravi.major.mappers.OrderMapper;
import com.ravi.major.model.Cart;
import com.ravi.major.model.Item;
import com.ravi.major.model.OrderItems;
import com.ravi.major.model.Product;
import com.ravi.major.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsServiceImpl {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private ItemService cartItemService;

    @Autowired
    private CartServiceImpl cartService;


    @Autowired
    private OrderItemsServiceImpl orderDetailService;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private OrderMapper orderMapper;


    public void saveOrder(OrderItems orderItems) {
        orderDetailsRepository.save(orderItems);

    }

    public List<OrderItems> getAllOrderDetails() {

        return orderDetailsRepository.findAll();


    }


    public void deleteOrderDetailsById(int id) {
        orderDetailsRepository.deleteById(id);

    }


    public OrderItems getOrderDetailById(int id) {
        return orderDetailsRepository.findById(id).get();
    }


    public void checkOrder(int userId) {
        Cart cart = cartService.getCartByUserId(userId);
        List<Item> items = cartItemService.getAllCardItemsByCartId(cart.getId());
        items.forEach(item -> {
            Product product = item.getProduct();
            int productId = product.getId();
            if(item.getQuantity()>productService.getProductById(productId).getQuantity() && item.getStatus()!= OrderStatus.PENDING){
                throw new ProductException("out of stock "+product.getName()+",remove from CartList");
            }
        });
    }

    public OrderDetail placeOrder(int userId) {
        ProceedItemResponse proceedItemResponse = cartItemService.orderedItems(userId);
        double tax=0.0;
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setPaymentStatus("Paid");
        if(proceedItemResponse.getTotalPrice()>10000){
          tax = proceedItemResponse.getTotalPrice()*(.005);
        }
        orderDetail.setPayablePrice(proceedItemResponse.getTotalPrice()-proceedItemResponse.getTotalDiscount()+tax);
        orderDetail.setItems(proceedItemResponse.getItems());
        orderDetail.setTax(tax);
        cartService.deleteItemById(cartService.getCartByUserId(userId).getId());
        return orderDetail;
    }

    public ProceedItemResponse proceedOrder(int userId){
        checkOrder(userId);
        return cartItemService.getItemOfActiveUser(userId);
    }

    public void updateOrderItem(OrderItems item) {

        orderDetailsRepository.save(item);
    }
    public void saveAllOrders(List<OrderItems> items){
        orderDetailsRepository.saveAll(items);
    }
}
