package com.ravi.major.service;


import com.ravi.major.model.BillingAddress;
import com.ravi.major.repository.BillingAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingAddressService {
    @Autowired
    private BillingAddressRepository billingAddressRepository;

    public void addBillingAddress(BillingAddress billingAddress){
        billingAddressRepository.save(billingAddress);
    }
}
