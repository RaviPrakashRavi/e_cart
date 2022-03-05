package com.ravi.major.mappers;

import com.ravi.major.dto.responseentity.AddressResponse;
import com.ravi.major.dto.responseentity.OrderViewDetail;
import com.ravi.major.dto.responseentity.ProductResponseDto;
import com.ravi.major.enums.OrderStatus;
import com.ravi.major.model.*;
import com.ravi.major.service.OrderServiceImpl;
import com.ravi.major.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private OrderServiceImpl orderService;


    public OrderViewDetail orderItemsToOrderDetailView(List<OrderItems> orderItems) {

        Order order = orderItems.get(0).getOrder();
       Customer customer = order.getUser().getCustomer();

        OrderViewDetail orderViewDetail = new OrderViewDetail();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        orderItems.forEach(orderItems1 -> {
            Product product = productService.getProductById(orderItems1.getProductId());
            product.setQuantity(orderItems1.getQuantity());
            ProductResponseDto productResponseDto = productMapper.ProductToProductResponseDto(product);
            productResponseDtos.add(productResponseDto);
        });
        orderViewDetail.setProducts(productResponseDtos);
        orderViewDetail.setCustomerName(customer.getName());
        AddressResponse addressResponse = addressMapper.addressToAddressResponse(customer.getAddress());
        orderViewDetail.setShippingAddress(addressResponse);
        orderViewDetail.setOrderId(order.getId());
        return orderViewDetail;
    }


    public List<OrderItems> cartItemsToOrderItems(List<Item> cartItems) {

        List<OrderItems> orderItems = new ArrayList<OrderItems>();

        cartItems.forEach(item -> {
            OrderItems orderItem = new OrderItems();
            Cart cart = item.getCart();
            User user = cart.getUser();
            System.out.println(user.getId());
            Order order = orderService.createOrder(user.getId());
            orderItem.setOrder(order);
            orderItem.setStatus(OrderStatus.SUCCESS);
            orderItem.setMerchantId(item.getProduct().getMerchant().getId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(item.getProduct().getPrice());
            orderItem.setName(item.getProduct().getName());
            orderItem.setDescription(item.getProduct().getDescription());
            orderItem.setCategory(item.getProduct().getCategory());
            orderItem.setCustomerId(user.getCustomer().getId());
            orderItem.setProductId(item.getProduct().getId());
            orderItems.add(orderItem);
        });

    return orderItems;
    }
}

