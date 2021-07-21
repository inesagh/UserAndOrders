package com.example.springjparelations.facade;

import com.example.springjparelations.annotation.Facade;
import com.example.springjparelations.controller.personcontroller.model.PersonRequest;
import com.example.springjparelations.controller.personcontroller.model.PersonResponse;
import com.example.springjparelations.converter.PersonConverter;
import com.example.springjparelations.persistence.model.Person;
import com.example.springjparelations.service.PersonService;
import org.springframework.stereotype.Component;

import java.util.List;

@Facade
public class PersonFacade {
    private final PersonService service;
    private final PersonConverter converter;

    public PersonFacade(PersonService service, PersonConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    public PersonResponse create(PersonRequest request){
        Person person = service.create(request);
        return converter.convertToResponse(person);
    }

    public List<PersonResponse> getAll(){
        List<Person> personList = service.getAll();
        return converter.convertListToResponse(personList);
    }

    public PersonResponse getById(Long id){
        Person byId = service.getById(id);
        return converter.convertToResponse(byId);
    }

    public List<PersonResponse> getByYourChoice(String term, String value){
        List<Person> byValue = service.getByYourChoice(term, value);
        return converter.convertListToResponse(byValue);
    }

    public PersonResponse update(Long id, PersonRequest request){
        Person updated = service.update(id, request);
        return converter.convertToResponse(updated);
    }

    public Boolean delete(Long id){
        return service.delete(id);
    }
}
