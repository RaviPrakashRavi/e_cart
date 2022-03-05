package com.ravi.major.dto.responseentity;
import com.ravi.major.enums.Brand;
import com.ravi.major.enums.CategoryType;

public class ProductResponseDto {

    private String productName;
    private Brand productBrand;
    private int quantity;
    private CategoryType category;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Brand getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(Brand productBrand) {
        this.productBrand = productBrand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }
}
