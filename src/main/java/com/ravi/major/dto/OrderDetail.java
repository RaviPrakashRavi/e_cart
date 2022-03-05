package com.ravi.major.dto;

import com.ravi.major.dto.responseentity.CartItemResponse;

import java.util.List;

public class OrderDetail {

    private List<ItemResponse> items;
    private double payablePrice;
    private String paymentStatus;
    private double tax = 0.0;

    public OrderDetail() {
    }

    public List<ItemResponse> getItems() {
        return items;
    }

    public void setItems(List<ItemResponse> items) {
        this.items = items;
    }

    public double getPayablePrice() {
        return payablePrice;
    }

    public void setPayablePrice(double payablePrice) {
        this.payablePrice = payablePrice;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
