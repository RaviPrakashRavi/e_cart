package com.ravi.major.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "country",nullable = false,length = 20)
    private String country;

    @Column(name = "state",nullable = false,length = 20)
    private String state;

    @Column(name = "city",nullable = false,length = 20)
    private String city;

    @Column(name = "mobile_number",nullable = false,length = 11)
    private String mobileNo;

    @Column(name = "pincode",nullable = false,length = 10)
    private String pinCode;

    @Column(name = "street",nullable = false,length = 20)
    private String street;

    @Column(name = "house_number",nullable = false,length = 10)
    private String houseNumber;

    @OneToOne(mappedBy = "address",cascade = CascadeType.PERSIST)
    private Merchant merchant;

    @OneToOne(mappedBy = "address",cascade = CascadeType.PERSIST)
    private Customer customer;

    @OneToOne(mappedBy = "address",cascade = CascadeType.PERSIST)
    private Admin admin;

    public Address() {

    }


    public Address(int id, String country, String state,
                   String pinCode, String street,
                   String houseNumber, String mobileNo) {
        this.id = id;
        this.country = country;
        this.state = state;
        this.pinCode = pinCode;
        this.street = street;
        this.houseNumber = houseNumber;
        this.mobileNo = mobileNo;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", mobileNo=" + mobileNo +
                ", pinCode='" + pinCode + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
