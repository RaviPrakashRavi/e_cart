package com.ravi.major.mappers;

import com.ravi.major.dto.requestentity.CustomerAddAddressRequest;
import com.ravi.major.dto.requestentity.CustomerUpdateAddressRequest;
import com.ravi.major.dto.requestentity.MerchantAddAddressRequest;
import com.ravi.major.dto.requestentity.MerchantUpdateAddressRequest;
import com.ravi.major.dto.responseentity.AddressResponse;
import com.ravi.major.model.Address;
import com.ravi.major.model.Customer;
import com.ravi.major.model.Merchant;
import com.ravi.major.service.CustomerService;
import com.ravi.major.service.MerchantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AddressMapper {

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ModelMapper modelMapper;

    public Address merchantAddressRequestToAddress(MerchantAddAddressRequest merchantAddAddressRequest,int userId){
        Merchant merchant = merchantService.findMerchantByUserId(userId);

        Address address = modelMapper.map(merchantAddAddressRequest,Address.class);
//        address.setMobileNo(merchantAddAddressRequest.getMobileNo());
//        address.setCity(merchantAddAddressRequest.getCity());
//        address.setStreet(merchantAddAddressRequest.getStreet());
//        address.setCountry(merchantAddAddressRequest.getCountry());
//        address.setState(merchantAddAddressRequest.getState());
//        address.setHouseNumber(merchantAddAddressRequest.getHouseNumber());
//        address.setPinCode(merchantAddAddressRequest.getPinCode());
        merchant.setAddress(address);
        address.setMerchant(merchant);
        return address;
    }

    public Address merchantUpdateAddressRequestToAddress(MerchantUpdateAddressRequest merchantUpdateAddressRequest){
        Merchant merchant = merchantService.findMerchantByUserId(1);
        Address address = merchant.getAddress();
        address.setId(merchantUpdateAddressRequest.getId());
        if(Objects.nonNull(merchantUpdateAddressRequest.getMobileNo())){
            address.setMobileNo(merchantUpdateAddressRequest.getMobileNo());
        }
        if(Objects.nonNull(merchantUpdateAddressRequest.getHouseNumber())) {
            address.setHouseNumber(merchantUpdateAddressRequest.getHouseNumber());
        }
        if(Objects.nonNull(merchantUpdateAddressRequest.getStreet())) {
            address.setStreet(merchantUpdateAddressRequest.getStreet());
        }
        if(Objects.nonNull(merchantUpdateAddressRequest.getCountry())) {
            address.setCountry(merchantUpdateAddressRequest.getCountry());
        }
        if(Objects.nonNull(merchantUpdateAddressRequest.getState())){
            address.setState(merchantUpdateAddressRequest.getState());
        }
        if(Objects.nonNull(merchantUpdateAddressRequest.getPinCode())){
            address.setPinCode(merchantUpdateAddressRequest.getPinCode());
        }
        if(Objects.nonNull(merchantUpdateAddressRequest.getCity())){
            address.setCity(merchantUpdateAddressRequest.getCity());
        }
        return address;
    }

    public AddressResponse addressToAddressResponse(Address address){
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setCity(address.getCity());
        addressResponse.setCountry(address.getCountry());
        addressResponse.setHouseNumber(address.getHouseNumber());
        addressResponse.setMobileNo(address.getMobileNo());
        addressResponse.setPinCode(address.getPinCode());
        addressResponse.setState(address.getState());
        addressResponse.setStreet(address.getStreet());
        return addressResponse;
    }

    public Address customerAddAddressRequestToAddress(CustomerAddAddressRequest customerAddAddressRequest,int userId){

        Customer customer = customerService.findCustomerByUserId(userId);
        Address address = new Address();
        address.setMobileNo(customerAddAddressRequest.getMobileNo());
        address.setCity(customerAddAddressRequest.getCity());
        address.setStreet(customerAddAddressRequest.getStreet());
        address.setCountry(customerAddAddressRequest.getCountry());
        address.setState(customerAddAddressRequest.getState());
        address.setHouseNumber(customerAddAddressRequest.getHouseNumber());
        address.setPinCode(customerAddAddressRequest.getPinCode());
        customer.setAddress(address);
        address.setCustomer(customer);
        return address;
    }
    public Address customerUpdateAddressRequestToAddress(CustomerUpdateAddressRequest customerUpdateAddressRequest, int userId){

        Customer customer = customerService.findCustomerByUserId(userId);
        Address address = customer.getAddress();
        address.setId(customerUpdateAddressRequest.getId());
        if(Objects.nonNull(customerUpdateAddressRequest.getMobileNo())){
            address.setMobileNo(customerUpdateAddressRequest.getMobileNo());
        }
        if(Objects.nonNull(customerUpdateAddressRequest.getHouseNumber())) {
            address.setHouseNumber(customerUpdateAddressRequest.getHouseNumber());
        }
        if(Objects.nonNull(customerUpdateAddressRequest.getStreet())) {
            address.setStreet(customerUpdateAddressRequest.getStreet());
        }
        if(Objects.nonNull(customerUpdateAddressRequest.getCountry())) {
            address.setCountry(customerUpdateAddressRequest.getCountry());
        }
        if(Objects.nonNull(customerUpdateAddressRequest.getState())){
            address.setState(customerUpdateAddressRequest.getState());
        }
        if(Objects.nonNull(customerUpdateAddressRequest.getPinCode())){
            address.setPinCode(customerUpdateAddressRequest.getPinCode());
        }
        if(Objects.nonNull(customerUpdateAddressRequest.getCity())){
            address.setCity(customerUpdateAddressRequest.getCity());
        }
        return address;
    }
}
