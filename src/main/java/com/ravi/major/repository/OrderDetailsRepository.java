package com.ravi.major.repository;

import com.ravi.major.enums.OrderStatus;
import com.ravi.major.model.Order;
import com.ravi.major.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderItems,Integer> {

    public List<OrderItems> findOrderItemsByOrderId(int orderId);
    public List<OrderItems>findOrderItemsByMerchantId(int merchantId);

    @Query("select  from OrderItems o where o.merchantId=:merchantId and o.status =:status Group By o.getOrder()")
    public Map<Order,List<OrderItems>>findOrderItemsByMerchantIdAndStatus(@Param("merchantId") int merchantId, @Param("status")OrderStatus status);

}
