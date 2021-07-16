package com.example.springjparelations.controller.personcontroller;

import com.example.springjparelations.controller.personcontroller.model.PersonRequest;
import com.example.springjparelations.controller.personcontroller.model.PersonResponse;
import com.example.springjparelations.facade.PersonFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final PersonFacade facade;

    public PersonController(PersonFacade facade) {
        this.facade = facade;
    }

    @PostMapping("person")
    public ResponseEntity<PersonResponse> create(@RequestBody PersonRequest request){
        return ResponseEntity.ok(facade.create(request));
    }

    @GetMapping("person/all")
    public ResponseEntity<List<PersonResponse>> getAll(){
        List<PersonResponse> all = facade.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("person")
    public ResponseEntity<List<PersonResponse>> getByYourChoice(@RequestParam String term,
                                                                @RequestParam String value){
        if(term.equals("id")) {
            List<PersonResponse> list = List.of(facade.getById((long) Integer.parseInt(value)));
            return ResponseEntity.ok(list);
        }else {
            return ResponseEntity.ok(facade.getByYourChoice(term, value));
        }
    }

    @PutMapping("person/{id}")
    public ResponseEntity<PersonResponse> update(@PathVariable Long id,
                                                 @RequestBody PersonRequest request){
        return ResponseEntity.ok(facade.update(id, request));
    }

    @DeleteMapping("person/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(facade.delete(id));
    }

}
