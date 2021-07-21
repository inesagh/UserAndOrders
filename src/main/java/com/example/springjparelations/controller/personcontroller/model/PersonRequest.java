package com.example.springjparelations.controller.personcontroller.model;

import com.example.springjparelations.controller.addresscontroller.model.AddressRequest;

public class PersonRequest {
    private String name;
    private String surname;
    private int age;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private AddressRequest address;
    private String role;

    public PersonRequest() {
    }

    public PersonRequest(String name, String surname, int age,
                         String email, String phoneNumber, String username,
                         String password, AddressRequest address, String role) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.address = address;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddressRequest getAddress() {
        return address;
    }

    public void setAddress(AddressRequest address) {
        this.address = address;
    }
}
