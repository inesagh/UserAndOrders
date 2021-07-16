package com.example.springjparelations.service;

import com.example.springjparelations.controller.addresscontroller.model.AddressRequest;
import com.example.springjparelations.converter.AddressConverter;
import com.example.springjparelations.persistence.model.Address;
import com.example.springjparelations.persistence.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository repository;
    private final AddressConverter converter;

    public AddressService(AddressRepository repository, AddressConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public Address create(AddressRequest request){
        Address address = converter.convertToEntity(request);
        Address saved = repository.save(address);
        return saved;
    }
}
