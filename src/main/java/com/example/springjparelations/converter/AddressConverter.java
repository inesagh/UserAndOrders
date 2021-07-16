package com.example.springjparelations.converter;

import com.example.springjparelations.annotation.Converter;
import com.example.springjparelations.controller.addresscontroller.model.AddressRequest;
import com.example.springjparelations.controller.addresscontroller.model.AddressResponse;
import com.example.springjparelations.persistence.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {

    public Address convertToEntity(AddressRequest request){
        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setCountry(request.getCountry());
        address.setZipOrPostalCode(request.getZipOrPostalCode());
        return address;
    }
    public AddressResponse convertToResponse(Address address){
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setStreet(address.getStreet());
        addressResponse.setCity(address.getCity());
        addressResponse.setState(address.getState());
        addressResponse.setCountry(address.getCountry());
        addressResponse.setZipOrPostalCode(address.getZipOrPostalCode());
        return addressResponse;
    }
}
