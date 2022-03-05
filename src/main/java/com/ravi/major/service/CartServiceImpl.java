package com.ravi.major.service;

import com.ravi.major.exception.NoItemSelected;
import com.ravi.major.model.Cart;
import com.ravi.major.model.User;
import com.ravi.major.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;


@Service
public class CartServiceImpl {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserServiceImpl userService;

    public void saveToCart(Cart cart) {

        cartRepository.save(cart);
    }

    public Cart createCartForUser(int userId) {

        Cart cart = cartRepository.findCartByUserId(userId);

        if (Objects.nonNull(cart)) {
            return cart;
        }
        cart = new Cart();
        User user = userService.getUserById(userId);

        cart.setUser(user);
        cart.setCreatedDate(new Date());
        return cartRepository.save(cart);
    }

    public void deleteItemById(int id) {
        cartRepository.deleteById(id);
    }

    public Cart getCartByUserId(int userId) {
        Cart cart = cartRepository.findCartByUserId(userId);
        if (Objects.isNull(cart)) {
            throw new NoItemSelected("you have not selected any items");
        }
        return cartRepository.findCartByUserId(userId);
    }
}
