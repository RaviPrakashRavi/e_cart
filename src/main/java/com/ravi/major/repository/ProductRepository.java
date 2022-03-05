package com.ravi.major.repository;

import com.ravi.major.enums.CategoryType;
import com.ravi.major.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> getAllProductByCategoryType(CategoryType categoryType);
    List<Product>findAllProductByMerchantId(int merchantId);

}
