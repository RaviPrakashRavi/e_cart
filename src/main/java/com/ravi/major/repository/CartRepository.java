package com.ravi.major.repository;

import com.ravi.major.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    Cart findCartByUserId(int userId);
}
