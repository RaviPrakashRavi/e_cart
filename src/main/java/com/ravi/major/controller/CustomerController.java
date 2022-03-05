package com.ravi.major.controller;

import com.ravi.major.dto.AddProductToCartItem;
import com.ravi.major.dto.requestentity.*;
import com.ravi.major.dto.responseentity.CartItemResponse;
import com.ravi.major.dto.responseentity.ProceedItemResponse;
import com.ravi.major.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private BillingAddressService billingAddressService;

    @PostMapping("/sign-up")
    public void signUpCustomer(@RequestBody CustomerSignUpRequest customerSignUpRequest) {
        customerService.signUpCustomer(customerSignUpRequest);
    }

    @PostMapping("/product")
    public void addProductToCart(@RequestBody AddProductToCartItem addProductToCartItem) {
        itemService.addItemToCartList(addProductToCartItem);
    }

    @PostMapping("/address/{userId}")
    public void addAddress(@RequestBody CustomerAddAddressRequest customerAddAddressRequest, @PathVariable("userId") int userId) {
        customerService.addAddress(customerAddAddressRequest, userId);

    }

    @PutMapping("/address/{userId}")
    public void updateAddress(@RequestBody CustomerUpdateAddressRequest customerUpdateAddressRequest, @PathVariable("userId") int userId) {
        customerService.updateAddress(customerUpdateAddressRequest, userId);
    }

    @PutMapping("/customer/{userId}")
    public void updateCustomer(@RequestBody CustomerUpdateRequest customerUpdateRequest, @PathVariable("userId") int userId) {
        userService.updateCustomer(customerUpdateRequest, userId);
    }

    @PostMapping("/billing-address/{userId}")
    public void addBillingAddress(@RequestBody AddressRequestDto addressRequestDto, @PathVariable int userId) {
        customerService.addBillingAddress(addressRequestDto, userId);
    }

    @PostMapping("/proceed-order/{userId}")
    public ProceedItemResponse proceedOrder(@PathVariable("userId") int userId) {
       return customerService.proceedOrder(userId);
    }

    @DeleteMapping("/item/{itemId}")
    public void deleteItemFromCartItem(@PathVariable("itemId") int itemId){
        customerService.removeItemFromCartItem(itemId);
    }
}
