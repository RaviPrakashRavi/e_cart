package com.ravi.major.model;

import com.ravi.major.enums.CategoryType;
import com.ravi.major.enums.OrderStatus;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "price", nullable = false, length = 20)
    private double price;

    @Column(name = "quantity", nullable = false, length = 20)
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 20)
    private CategoryType categoryType;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "discount", nullable = false, length = 2)
    private int discount;

    @Column(name = "product_name", nullable = false, length = 20)
    private String name;

    private int productId;

    private int merchantId;

    private int customerId;

    @Column(name = "status", length = 10)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public OrderItems() {
    }

    public OrderItems(int id, Order order, double price, int quantity,
                      CategoryType category, String description,
                      int discount, String name) {
        this.id = id;
        this.order = order;
        this.price = price;
        this.quantity = quantity;
        this.categoryType = category;
        this.description = description;
        this.discount = discount;
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategory(CategoryType category) {
        this.categoryType = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "id=" + id +
                ", order=" + order +
                ", price=" + price +
                ", quantity=" + quantity +
                ", categoryType=" + categoryType +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", name='" + name + '\'' +
                ", productId=" + productId +
                ", merchantId=" + merchantId +
                ", customerId=" + customerId +
                ", status=" + status +
                '}';
    }
}
