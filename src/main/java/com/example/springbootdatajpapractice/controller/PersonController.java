package com.example.springbootdatajpapractice.controller;

import com.example.springbootdatajpapractice.model.Person;
import com.example.springbootdatajpapractice.model.PersonId;
import com.example.springbootdatajpapractice.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(path = "person/save", consumes = "application/json")
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("search/person")
    public Optional<Person> findById(@RequestParam("firstname") String firstname, @RequestParam("surname") String surname, @RequestParam("age") int age) {
        return personService.findById(new PersonId(firstname, surname, age));
    }

    @GetMapping("print/all-persons")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @DeleteMapping("delete/person")
    public void deleteById(@RequestParam("firstname") String firstname, @RequestParam("surname") String surname, @RequestParam("age") int age) {
        personService.deleteById(new PersonId(firstname, surname, age));
    }

    @GetMapping("persons/by-city")
    public List<Person> findPersonByCityOfLiving(@RequestParam String city) {
        return personService.findPersonByCityOfLiving(city);
    }

    @GetMapping("persons/by-age")
    public List<Person> findPersonByPersonIdAgeLessThanOrderByPersonId(@RequestParam int age) {
        return personService.findPersonByPersonIdAgeLessThanOrderByPersonId(age);
    }

    @GetMapping("persons/person-by-firstname-surname")
    public List<Person> findPersonByPersonId_FirstnameAndPersonId_Surname(@RequestParam Optional<String> firstname, @RequestParam Optional<String> surname) {
        return personService.findPersonByPersonId_FirstnameAndPersonId_Surname(firstname, surname);
    }
}
