package com.example.springjparelations.persistence.repository;

import com.example.springjparelations.persistence.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findPeopleByUsername(String username);
    List<Person> findPeopleByAge(Integer age);
    List<Person> findPeopleByName(String name);
    List<Person> findPeopleBySurname(String surname);
    List<Person> findPeopleByEmail(String email);
}
