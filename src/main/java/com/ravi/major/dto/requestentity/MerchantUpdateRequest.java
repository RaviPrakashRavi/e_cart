package com.ravi.major.dto.requestentity;

import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

public class MerchantUpdateRequest {


    private int id;

    @Pattern(regexp = "^[\\p{L} .'-]+$")
    @NotBlank
    private String name;

    @Pattern(regexp = "^[6-9]\\d{9}+$")
    private String mobileNumber;

    @Email
    private String email;

    private String registrationId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
}
