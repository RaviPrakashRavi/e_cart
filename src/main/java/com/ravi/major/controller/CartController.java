package com.ravi.major.controller;

import com.ravi.major.dto.AddProductToCartItem;
import com.ravi.major.dto.UpdateQuantityOfItem;
import com.ravi.major.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private ItemService cartItemService;

    @PostMapping("/product")
    public void addProductToCart(@RequestBody AddProductToCartItem addProductToCartItem) {
        cartItemService.addItemToCartList(addProductToCartItem);
    }

    @PutMapping("/quantity")
    public void updateQuantity(@RequestBody UpdateQuantityOfItem updateQuantityOfItem) {
        cartItemService.updateQuantity(updateQuantityOfItem);
    }

    @DeleteMapping("/item")
    public void deleteItem(@RequestParam int cartItemId) {
        cartItemService.deleteCartItem(cartItemId);
    }

//    @GetMapping("/items/{userId}")
//    public List<CartItemResponse> getAllCartItemOfActiveUser(@PathVariable("userId") int userId)
//    {
//        return cartItemService.getItemOfActiveUser(userId);
//    }

}
