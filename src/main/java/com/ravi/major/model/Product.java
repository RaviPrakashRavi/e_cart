package com.ravi.major.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ravi.major.enums.Brand;
import com.ravi.major.enums.CategoryType;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoryType", nullable = false, length = 20)
    private CategoryType categoryType;

    @Column(name = "product_price", nullable = false, length = 10)
    private double price;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "quantity", nullable = false, length = 5)
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "brand", nullable = false, length = 20)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id")
    @JsonManagedReference
    private Merchant merchant;

    @Column(name = "discount")
    @Max(value = 100)
    @Min(value = 0)
    private int discount;

    public Product() {
    }

    public Product(int id, CategoryType category, double price,
                   String description, String name,
                   int quantity, Brand brand,
                   Merchant merchant) {
        this.id = id;
        this.categoryType = category;
        this.price = price;
        this.description = description;
        this.name = name;
        this.quantity = quantity;
        this.brand = brand;
        this.merchant = merchant;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryType getCategory() {
        return categoryType;
    }

    public void setCategory(CategoryType category) {
        this.categoryType = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}


