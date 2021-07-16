package com.example.springjparelations.service;

import com.example.springjparelations.controller.addresscontroller.model.AddressRequest;
import com.example.springjparelations.controller.personcontroller.model.PersonRequest;
import com.example.springjparelations.converter.PersonConverter;
import com.example.springjparelations.persistence.model.Address;
import com.example.springjparelations.persistence.model.Person;
import com.example.springjparelations.persistence.repository.PersonRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final AddressService addressService;
    private final PersonRepository repository;
    private final PersonConverter converter;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public PersonService(AddressService addressService, PersonRepository repository, PersonConverter converter) {
        this.addressService = addressService;
        this.repository = repository;
        this.converter = converter;
    }

    public Person create(PersonRequest request) {
        Person person = buildPerson(request);
        Person saved = repository.save(person);
        return saved;
    }

    public List<Person> getAll(){
        List<Person> all = repository.findAll();
        return all;
    }

    public Person getById(Long id){
        return repository.getById(id);
    }

    public List<Person> getByYourChoice(String term, String value){
        if(term.equals("name")){
            return repository.findPeopleByName(value);
        }else if(term.equals("surname")){
            return repository.findPeopleBySurname(value);
        }else if(term.equals("username")){
            return repository.findPeopleByUsername(value);
        }else if(term.equals("age")){
            return repository.findPeopleByAge(Integer.parseInt(value));
        }else if(term.equals("email")){
            return repository.findPeopleByEmail(value);
        }else{
            return null;
        }
    }

    public Person update(Long id, PersonRequest request){
        Person person = buildPerson(request);
        Person byId = repository.getById(id);
        byId.setAddress(person.getAddress());
        byId.setName(person.getName());
        byId.setSurname(person.getSurname());
        byId.setAge(person.getAge());
        byId.setEmail(person.getEmail());
        byId.setPhoneNumber(person.getPhoneNumber());
        byId.setUsername(person.getUsername());
        byId.setPassword(person.getPassword());
        Person updated = repository.save(byId);
        return updated;
    }

    public Boolean delete(Long id){
        repository.delete(repository.getById(id));
        return !repository.existsById(id);
    }

    public Person buildPerson(PersonRequest request){
        String encodedPassword = bCryptPasswordEncoder.encode(request.getPassword());
        request.setPassword(encodedPassword);

        Person person = new Person();
        person.setName(request.getName());
        person.setSurname(request.getSurname());
        person.setAge(request.getAge());
        person.setEmail(request.getEmail());
        person.setPhoneNumber(request.getPhoneNumber());
        person.setUsername(request.getUsername());
        person.setPassword(request.getPassword());
        AddressRequest address = request.getAddress();
        Address savedAddress = addressService.create(address);
        person.setAddress(savedAddress);
        return person;
    }
}
