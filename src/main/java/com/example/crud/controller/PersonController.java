package com.example.crud.controller;

import com.example.crud.model.Person;
import com.example.crud.repository.PersonRepository;
import com.example.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person) {
        return service.savePerson(person);
    }

    @PostMapping("/addPersons")
    public List<Person> addPersons(@RequestBody List<Person> persons) {
        return service.savePersons(persons);
    }

    @GetMapping("/persons")
    public List<Person> findAllPersons() {
        return service.getPersons();
    }

    @GetMapping("/personById/{id}")
    public Person findPersonById(@PathVariable int id) {
        return service.getPersonById(id);
    }

    @GetMapping("/personByName/{name}")
    public Person findPersonByName(@PathVariable String name) {
        return service.getPersonByName(name);
    }

    @PutMapping("/updatePerson")
    public Person updatePerson(@RequestBody Person person) {
        return service.updatePerson(person);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id) {
        return service.deletePerson(id);
    }
}
