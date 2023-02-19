package com.example.crud.service;

import com.example.crud.model.Person;
import com.example.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepo;

//    POST method
    public Person savePerson(Person person) {
        return personRepo.save(person);
    }

    public List<Person> savePersons(List<Person> persons) {
        return personRepo.saveAll(persons);
    }

//    GET method
    public Person getPersonById(int id) {
        return personRepo.findById(id).orElse(null);
    }

    public Person getPersonByName(String name) {
        return personRepo.findByName(name);
    }

    public List<Person> getPersons() {
        return personRepo.findAll();
    }

//    DELETE method
    public String deletePerson(int id) {
        personRepo.deleteById(id);
        return "Person deleted: " + id;
    }

//    PUT method
    public Person updatePerson(Person person) {
        Person existingPerson = getPersonById(person.getId());
        existingPerson.setName(person.getName());
        existingPerson.setAge(person.getAge());
        existingPerson.setLanguage(person.getLanguage());
        return personRepo.save(existingPerson);
    }
}
