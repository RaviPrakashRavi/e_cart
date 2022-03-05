package com.ravi.major.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ravi.major.dto.AddProductToCartItem;
import com.ravi.major.dto.requestentity.CartItemRequestDto;
import com.ravi.major.dto.UpdateQuantityOfItem;
import com.ravi.major.dto.responseentity.CartItemResponse;
import com.ravi.major.dto.responseentity.ProceedItemResponse;
import com.ravi.major.enums.OrderStatus;
import com.ravi.major.mappers.CartMapper;
import com.ravi.major.model.*;
import com.ravi.major.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderItemsServiceImpl orderItemsService;

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public void deleteItem(int itemId) {
        itemRepository.deleteById(itemId);
    }

    public void deleteAllByCartId(int cartId) {
        List<Item> items = itemRepository.getAllCardItemsByCartId(cartId);
        for (Item item : items) {
            int id = item.getId();
            itemRepository.deleteById(id);
        }
    }

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public List<Item> getAllCardItemsByCartId(int id) {
        return itemRepository.
                getAllCardItemsByCartId(id);
    }


    public void addItemToCartList(AddProductToCartItem addProductToCartItem) {

        Cart cart = cartService.createCartForUser(addProductToCartItem.getUserId());
        Product product = productService.getProductById(addProductToCartItem.getProductId());
        Item item = new Item();
        item.setCart(cart);
        item.setAddedDate(new Date());
        item.setProduct(product);
        item.setQuantity(addProductToCartItem.getQuantity());
        item.setStatus(OrderStatus.PENDING);
        itemRepository.save(item);
    }

    public void updateQuantity(UpdateQuantityOfItem updateQuantityOfItem) {
        Item item = itemRepository.findById(updateQuantityOfItem.getCartItemId()).get();
        item.setQuantity(updateQuantityOfItem.getQuantity());
        itemRepository.save(item);

    }

    public void deleteCartItem(int cartItemId) {
        itemRepository.deleteById(cartItemId);
    }

    public ProceedItemResponse getItemOfActiveUser(int userId) {
        int cartId = cartService.getCartByUserId(userId).getId();
        List<Item> items = itemRepository.getAllCardItemsByCartId(cartId);
        items.forEach(item -> {
            item.setStatus(OrderStatus.PROCEED);
        });
        itemRepository.saveAll(items);
        return cartMapper.itemsToCartItemResponse(items);
    }

    public ProceedItemResponse orderedItems(int userId) {
        int cartId = cartService.getCartByUserId(userId).getId();
        List<Item> items = itemRepository.getAllCardItemsByCartId(cartId);
        Order order = orderService.createOrder(userId);
        order.setOrderedDate(new Date());
        order.setStatus(OrderStatus.PLACED);
        List<OrderItems>orderItems = new ArrayList<>();
        items.forEach(item -> {
            OrderItems orderItem = new OrderItems();
            orderItem.setCategory(item.getProduct().getCategory());
            orderItem.setProductId(item.getProduct().getId());
            orderItem.setOrder(order);
            orderItem.setPrice(item.getProduct().getPrice());
            orderItem.setDescription(item.getProduct().getDescription());
            orderItem.setName(item.getProduct().getName());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setStatus(OrderStatus.PLACED);
            orderItem.setMerchantId(item.getProduct().getMerchant().getId());
            orderItem.setDiscount(item.getProduct().getDiscount());
            orderItem.setCustomerId(cartService.getCartByUserId(userId).getUser().getCustomer().getId());
            orderItems.add(orderItem);
        });
        orderItemsService.saveAllOrders(orderItems);
        return cartMapper.itemsToCartItemResponse(items);
    }
}
