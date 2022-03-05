package com.ravi.major.service;

import com.ravi.major.dto.requestentity.*;
import com.ravi.major.dto.responseentity.CartItemResponse;
import com.ravi.major.dto.responseentity.ProceedItemResponse;
import com.ravi.major.exception.UserException;
import com.ravi.major.mappers.AddressMapper;
import com.ravi.major.mappers.CustomerMapper;
import com.ravi.major.mappers.PaymentMapper;
import com.ravi.major.model.*;
import com.ravi.major.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private AddressService addressService;

    @Autowired
    private BillingAddressService billingAddressService;
//
//    @Autowired
//    private OrderServiceImpl orderService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderItemsServiceImpl orderItemsService;

    public Customer getByCustomerId(int customerId) {
        Optional<Customer> optional = customerRepository.findById(customerId);
        if (optional.isEmpty()) {
            throw new UserException("customer not found");
        }
        return optional.get();
    }

    public void signUpCustomer(CustomerSignUpRequest customerSignUpRequest) {
        User user = customerMapper.customerSignUpToUser(customerSignUpRequest);
        userService.saveUser(user);
    }

    public void addAddress(CustomerAddAddressRequest customerAddAddressRequest, int userId) {
        Address address = addressMapper.customerAddAddressRequestToAddress(customerAddAddressRequest, userId);
        addressService.saveAddress(address);
    }

    public Customer findCustomerByUserId(int userId) {
        return customerRepository.findCustomerByUserId(userId);
    }

    public void updateAddress(CustomerUpdateAddressRequest customerUpdateAddressRequest, int userId) {
        Address address = addressMapper.customerUpdateAddressRequestToAddress(customerUpdateAddressRequest, userId);
        addressService.updateAddress(address);
    }

    public void addBillingAddress(AddressRequestDto addressDto, int userId) {
        BillingAddress billingAddress = customerMapper.addressDtoToBillingAddress(addressDto, userId);
        billingAddressService.addBillingAddress(billingAddress);
    }

    public ProceedItemResponse proceedOrder(int userId) {

        return orderItemsService.proceedOrder(userId);
    }

    public void removeItemFromCartItem(int itemId) {
        itemService.deleteCartItem(itemId);
    }

    public String makePayment(PaymentRequest paymentRequest){
        Payment payment = paymentMapper.paymentRequestToPayment(paymentRequest);
        paymentService.makePayment(payment);
        return payment.getStatus();
    }
}
