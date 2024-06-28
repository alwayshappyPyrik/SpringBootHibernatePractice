package com.example.springbootdatajpapractice.service;

import com.example.springbootdatajpapractice.model.Person;
import com.example.springbootdatajpapractice.model.PersonId;
import com.example.springbootdatajpapractice.repository.CustomizedPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final CustomizedPersonRepository personRepository;

    public PersonService(CustomizedPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> findById(PersonId personId) {
        return personRepository.findById(personId);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void deleteById(PersonId personId) {
        personRepository.deleteById(personId);
    }

    public List<Person> findPersonByCityOfLiving(String city) {
        return personRepository.findPersonByCityOfLiving(city);
    }

    public List<Person> findPersonByPersonIdAgeLessThanOrderByPersonId(int age) {
        return personRepository.findPersonByPersonIdAgeLessThanOrderByPersonId(age);
    }

    public List<Person> findPersonByPersonId_FirstnameAndPersonId_Surname(Optional<String> firstname, Optional<String> surname) {
        return personRepository.findPersonByPersonId_FirstnameAndPersonId_Surname(firstname, surname);
    }
}
