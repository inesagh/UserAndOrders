package com.example.springjparelations.converter;

import com.example.springjparelations.controller.addresscontroller.model.AddressResponse;
import com.example.springjparelations.controller.personcontroller.model.PersonResponse;
import com.example.springjparelations.persistence.model.Address;
import com.example.springjparelations.persistence.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonConverter {

    private final AddressConverter addressConverter;

    public PersonConverter(AddressConverter addressConverter) {
        this.addressConverter = addressConverter;
    }

    public PersonResponse convertToResponse(Person person){
        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(person.getId());
        personResponse.setName(person.getName());
        personResponse.setSurname(person.getSurname());
        personResponse.setAge(person.getAge());
        personResponse.setEmail(person.getEmail());
        personResponse.setPhoneNumber(person.getPhoneNumber());
        personResponse.setUsername(person.getUsername());
        Address address = person.getAddress();
        AddressResponse addressResponse = addressConverter.convertToResponse(address);
        personResponse.setAddress(addressResponse);
        return personResponse;
    }

    public List<PersonResponse> convertListToResponse(List<Person> personList){
        List<PersonResponse> collected = personList.stream().map(each -> convertToResponse(each))
                .collect(Collectors.toList());
        return collected;
    }
}
