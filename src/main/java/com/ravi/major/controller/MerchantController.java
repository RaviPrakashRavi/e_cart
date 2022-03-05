package com.ravi.major.controller;

import com.ravi.major.dto.requestentity.*;
import com.ravi.major.dto.responseentity.MerchantSignUpResponse;
import com.ravi.major.dto.responseentity.OrderViewDetail;
import com.ravi.major.dto.responseentity.ProductResponseDto;
import com.ravi.major.service.MerchantService;
import com.ravi.major.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private ProductServiceImpl productService;


    @PostMapping(value = "/sign-up", consumes = {"application/json"})
    public ResponseEntity<MerchantSignUpResponse> signUpMerchant(@Valid @RequestBody MerchantSignUpRequest merchantSignUpRequestDto) {
        return merchantService.signUpMerchant(merchantSignUpRequestDto);
    }

    @PostMapping(value = "/product/{userId}", consumes = {"application/json"})
    public void addProduct(@Valid @RequestBody ProductAddRequest productAddRequest, @PathVariable("userId") int userId) {
        merchantService.addProduct(productAddRequest, userId);
    }

    @DeleteMapping("/product/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId) {
        productService.deleteProductById(productId);
    }

    @PutMapping("/product")
    public void updateProduct(@Valid @RequestBody ProductUpdateRequest productUpdateRequest) {
        merchantService.updateProduct(productUpdateRequest);
    }

    @GetMapping("/products")
    List<ProductResponseDto> getAllProducts() {
        return merchantService.findProducts();
    }

    @PutMapping("/merchant")
    public void updateMerchant(@Valid @RequestBody MerchantUpdateRequest merchantUpdateRequest) {
        merchantService.updateMerchant(merchantUpdateRequest);
    }

    @GetMapping("/view-order/{userId}")
    public List<OrderViewDetail> viewOrder(@PathVariable("userId") int userId) {
        return merchantService.viewOrders(userId);
    }

    @PostMapping("/address/{userId}")
    public void addAddress(@RequestBody MerchantAddAddressRequest merchantAddressRequest, @PathVariable("userId") int userId) {
        merchantService.addMerchantAddress(merchantAddressRequest, userId);
    }

    @PutMapping("/address")
    public void updateAddress(@RequestBody MerchantUpdateAddressRequest merchantUpdateAddressRequest) {
        merchantService.updateAddress(merchantUpdateAddressRequest);
    }

    @PostMapping("/dispatch/{userId}")
    public void sendOrderItem(@PathVariable("userId") int userId) {
       // merchantService.sendOrderItem(userId);
    }

    @PostMapping("/cancel/{userId}")
    public void cancelOrder(@PathVariable("userId") int userId) {
       // merchantService.cancelOrder(userId);
    }
}
