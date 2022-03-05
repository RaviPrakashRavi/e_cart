package com.ravi.major.dto.responseentity;

import java.util.List;

public class OrderViewDetail {
    private String customerName;
    private List<ProductResponseDto> products;
    private AddressResponse shippingAddress;
    private int orderId;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<ProductResponseDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponseDto> products) {
        this.products = products;
    }

    public void setShippingAddress(AddressResponse shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public AddressResponse getShippingAddress() {
        return shippingAddress;
    }
}
