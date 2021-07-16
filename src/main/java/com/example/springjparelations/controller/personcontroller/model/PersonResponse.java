package com.example.springjparelations.controller.personcontroller.model;

import com.example.springjparelations.controller.addresscontroller.model.AddressResponse;
import com.example.springjparelations.persistence.model.Address;

public class PersonResponse {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String phoneNumber;
    private String username;
    private AddressResponse address;

    public PersonResponse() {
    }

    public PersonResponse(Long id, String name, String surname, int age,
                          String email, String phoneNumber, String username,
                          AddressResponse address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(AddressResponse address) {
        this.address = address;
    }
}
