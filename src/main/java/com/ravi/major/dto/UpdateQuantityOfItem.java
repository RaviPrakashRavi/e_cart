package com.ravi.major.dto;

public class UpdateQuantityOfItem {

    private int cartItemId;
    private int quantity;

    public UpdateQuantityOfItem() {
    }
    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
