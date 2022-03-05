package com.ravi.major.service;

import com.ravi.major.exception.ProductException;
import com.ravi.major.mappers.ProductMapper;
import com.ravi.major.model.Product;
import com.ravi.major.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private ProductMapper productMapper;


    public void addProduct(Product product) {

        productRepository.save(product);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductById(int productId) {
        int merchantId = merchantService.findMerchantByUserId(1).getId();
        int productMerchantId = productRepository.findById(productId).get().getMerchant().getId();
        if (merchantId != productMerchantId) {
            throw new ProductException("bad request");
        }
        productRepository.deleteById(productId);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product getProductById(int id) {

        Optional<Product> optional = productRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ProductException("Sorry!,This product is not available");
        }
        return optional.get();
    }


    public List<Product> findAllProductOfMerchant() {
        return productRepository.findAllProductByMerchantId(merchantService
                .findMerchantByUserId(1).getId());
    }
}
