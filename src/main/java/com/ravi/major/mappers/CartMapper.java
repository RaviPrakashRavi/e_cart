package com.ravi.major.mappers;

import com.ravi.major.dto.ItemResponse;
import com.ravi.major.dto.responseentity.CartItemResponse;
import com.ravi.major.dto.responseentity.ProceedItemResponse;
import com.ravi.major.model.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartMapper {

    public ProceedItemResponse itemsToCartItemResponse(List<Item> items) {
        ProceedItemResponse itemResponses = new ProceedItemResponse();
        List<ItemResponse> itemResponse = new ArrayList<>();
        items.forEach(item -> {
            CartItemResponse cartItemResponse = new CartItemResponse();
            cartItemResponse.setProductName(item.getProduct().getName());
            cartItemResponse.setBrand(item.getProduct().getBrand());
            cartItemResponse.setPrice(item.getProduct().getPrice());
            cartItemResponse.setType(item.getProduct().getCategory());
            cartItemResponse.setQuantity(item.getQuantity());
            itemResponses.setTotalPrice(itemResponses.getTotalPrice()+item.getProduct().getPrice()*item.getQuantity());
            itemResponses.setTotalDiscount(itemResponses.getTotalDiscount()+(item.getProduct().getPrice())*(item.getProduct().getDiscount())/100);
            itemResponse.add(cartItemResponse);
        });
        itemResponses.setTotalItems(items.size());
        itemResponses.setItems(itemResponse);
        return itemResponses;
    }
}
