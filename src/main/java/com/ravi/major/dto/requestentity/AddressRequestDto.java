package com.ravi.major.dto.requestentity;

public class AddressRequestDto {
    private String country;
    private String state;
    private String city;
    private String mobileNo;
    private String pinCode;
    private String street;
    private String houseNumber;

    public AddressRequestDto() {
    }

    public AddressRequestDto(String country,
                             String state, String city,
                             String mobileNo, String pinCode,
                             String street, String houseNumber) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.mobileNo = mobileNo;
        this.pinCode = pinCode;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

}
