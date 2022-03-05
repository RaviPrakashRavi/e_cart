package com.ravi.major.repository;

import com.ravi.major.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order getOrderByUserId(int userId);
}
