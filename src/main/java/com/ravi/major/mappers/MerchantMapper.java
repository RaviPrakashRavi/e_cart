package com.ravi.major.mappers;

import com.ravi.major.dto.requestentity.MerchantSignUpRequest;
import com.ravi.major.dto.requestentity.MerchantUpdateRequest;
import com.ravi.major.dto.responseentity.MerchantSignUpResponse;
import com.ravi.major.enums.UserType;
import com.ravi.major.model.Merchant;
import com.ravi.major.model.User;
import com.ravi.major.service.MerchantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MerchantMapper {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private ModelMapper modelMapper;

    //    public Merchant merchantDtoToMerchant(MerchantSignUpRequest merchantDto){
//
//        Merchant merchant = new Merchant();
//        merchant.setEmail(merchantDto.getEmail());
//        merchant.setName(merchantDto.getName());
//        merchant.setRegistrationId(merchantDto.getRegistrationId());
//        merchant.setMobileNumber(merchantDto.getMobileNumber());
//
//
//        return merchant;
//    }
    public User merchantDtoToUser(MerchantSignUpRequest merchantDto) {
        Merchant merchant = new Merchant();
        merchant.setEmail(merchantDto.getEmail());
        merchant.setName(merchantDto.getName());
        merchant.setRegistrationId(merchantDto.getRegistrationId());
        merchant.setMobileNumber(merchantDto.getMobileNumber());
        User user = new User();
        merchant.setUser(user);
        user.setMerchant(merchant);
        user.setUserName(merchantDto.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(merchantDto.getPassword()));
        user.setType(UserType.MERCHANT);
        return user;
    }

    public MerchantSignUpResponse merchantDtoToMerchantSignUpResponse(MerchantSignUpRequest merchantDto) {

        MerchantSignUpResponse merchantSignUpResponse = new MerchantSignUpResponse();
        merchantSignUpResponse.setUserName(merchantDto.getUserName());
        merchantSignUpResponse.setName(merchantDto.getName());
        merchantSignUpResponse.setMessage("Done!");
        return merchantSignUpResponse;
    }

    public Merchant merchantUpdateRequestDtoToMerchant(MerchantUpdateRequest merchantUpdateRequest) {

        Merchant merchant = merchantService.findMerchantById(merchantUpdateRequest.getId());
        if (Objects.nonNull(merchantUpdateRequest.getName())) {
            merchant.setName(merchantUpdateRequest.getName());
        }
        if (Objects.nonNull(merchantUpdateRequest.getEmail())) {
            merchant.setEmail(merchantUpdateRequest.getEmail());
        }
        if (Objects.nonNull(merchantUpdateRequest.getMobileNumber())) {
            merchant.setMobileNumber(merchantUpdateRequest.getMobileNumber());
        }
        if (Objects.nonNull(merchantUpdateRequest.getRegistrationId())) {
            merchant.setRegistrationId(merchantUpdateRequest.getRegistrationId());
        }
        return merchant;
    }

}
