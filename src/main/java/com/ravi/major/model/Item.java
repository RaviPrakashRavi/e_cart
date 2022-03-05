package com.ravi.major.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ravi.major.enums.OrderStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cart_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonManagedReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    private Date addedDate;
    private int quantity;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Item() {
    }

    public Item(int id, Product product, Cart cart, Date addedDate, int quantity) {
        this.id = id;
        this.product = product;
        this.cart = cart;
        this.addedDate = addedDate;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
