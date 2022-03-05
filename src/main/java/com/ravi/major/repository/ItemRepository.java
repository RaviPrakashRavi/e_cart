package com.ravi.major.repository;

import com.ravi.major.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    public List<Item> getAllCardItemsByCartId(int cartId);

}
