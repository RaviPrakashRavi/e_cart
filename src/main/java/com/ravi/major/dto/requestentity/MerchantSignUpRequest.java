package com.ravi.major.dto.requestentity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
public class MerchantSignUpRequest {

    @NotEmpty
    @Pattern(regexp = "[a-zA-Z]+")
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "[6789]{1}\\d{9}")
    private String mobileNumber;

    @NotBlank
    @NotEmpty
    private String registrationId;

    @NotBlank
    private String userName;

    @Pattern(regexp = "^(?=.*[0-9])"
            + "^(?=.*[a-z])^(?=.*[A-Z])"
            + "^(?=.*[@#$%^&*+=])"
            + "(?=\\S+$).{8,20}$", message = "not matched")
    private String password;



    public String getEmail() {
        return email;
    }


    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {

        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
