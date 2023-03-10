package com.example.crud.repository;

import com.example.crud.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByName(String name);
}
