package com.ravi.major.mappers;

import com.ravi.major.dto.requestentity.AddressRequestDto;
import com.ravi.major.dto.requestentity.CustomerSignUpRequest;
import com.ravi.major.dto.requestentity.CustomerUpdateRequest;
import com.ravi.major.enums.UserType;
import com.ravi.major.model.BillingAddress;
import com.ravi.major.model.Customer;
import com.ravi.major.model.User;
import com.ravi.major.service.CustomerService;
import com.ravi.major.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomerMapper {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserServiceImpl userService;

    public Customer customerSignUpRequestToCustomer(CustomerSignUpRequest customerSignUpRequest){
        Customer customer = new Customer();
        customer.setName(customerSignUpRequest.getName());
        System.out.println(customerSignUpRequest.getGender());
        customer.setGender(customerSignUpRequest.getGender());
        return customer;
    }
    public User customerSignUpToUser(CustomerSignUpRequest customerSignUpRequest){
        User user = new User();
        Customer customer = customerSignUpRequestToCustomer(customerSignUpRequest);
        user.setUserName(customerSignUpRequest.getUserName());
        customer.setUser(user);
        user.setType(UserType.CONSUMER);
        user.setPassword(bCryptPasswordEncoder.encode(customerSignUpRequest.getPassword()));
        user.setCustomer(customer);
        return user;
    }
    public Customer customerUpdateRequestToCustomer(CustomerUpdateRequest customerUpdateRequest,int userId){

        Customer customer = customerService.findCustomerByUserId(userId);
        if(Objects.nonNull(customerUpdateRequest.getName())){
            customer.setName(customerUpdateRequest.getName());
        }

        return customer;
    }
    public User customerUpdateRequestToUser(CustomerUpdateRequest customerUpdateRequest, int userId){
        User user = userService.getUserById(userId);
        Customer customer = user.getCustomer();
        if(Objects.nonNull(customerUpdateRequest.getName())){
            customer.setName(customerUpdateRequest.getName());
        }

        if(Objects.nonNull(customerUpdateRequest.getPassword())){
            user.setPassword(bCryptPasswordEncoder.encode(customerUpdateRequest.getPassword()));
        }

        return user;
    }

    public BillingAddress addressDtoToBillingAddress(AddressRequestDto addressDto, int userId) {

        Customer customer = customerService.findCustomerByUserId(userId);
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setCustomer(customer);
        billingAddress.setCity(addressDto.getCity());
        billingAddress.setCountry(addressDto.getCountry());
        billingAddress.setHouseNumber(addressDto.getHouseNumber());
        billingAddress.setState(addressDto.getState());
        billingAddress.setMobileNo(addressDto.getMobileNo());
        billingAddress.setPinCode(addressDto.getPinCode());
        billingAddress.setStreet(addressDto.getStreet());
        return billingAddress;
    }
}
