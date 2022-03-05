package com.ravi.major.controller;

import com.ravi.major.model.Product;
import com.ravi.major.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;


    @DeleteMapping("/product")
    public void deleteProduct(@RequestParam int productId) {
    }

    @GetMapping("/list")
    List<Product> getProducts() {
        return productService.getAllProducts();
    }

}

