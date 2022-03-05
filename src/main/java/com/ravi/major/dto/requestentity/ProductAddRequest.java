package com.ravi.major.dto.requestentity;

import com.ravi.major.enums.Brand;
import com.ravi.major.enums.CategoryType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ProductAddRequest {
    private String productName;
    private double price;
    private String description;
    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private Brand brand;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
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

}
