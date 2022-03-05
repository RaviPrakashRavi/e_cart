package com.ravi.major.service;
import com.ravi.major.model.Address;
import com.ravi.major.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private BillingAddressService billingAddressService;


    public void saveAddress(Address address) {
        addressRepository.save(address);
    }
    public void updateAddress(Address address) {
        addressRepository.save(address);
    }
    public void deleteAddress(int addressId){addressRepository.deleteById(addressId);}

}
