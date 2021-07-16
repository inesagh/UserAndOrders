package com.example.springjparelations.controller.addresscontroller.model;

public class AddressRequest {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipOrPostalCode;

    public AddressRequest() {
    }

    public AddressRequest(String street, String city, String state,
                          String country, String zipOrPostalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipOrPostalCode = zipOrPostalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipOrPostalCode() {
        return zipOrPostalCode;
    }

    public void setZipOrPostalCode(String zipOrPostalCode) {
        this.zipOrPostalCode = zipOrPostalCode;
    }
}
