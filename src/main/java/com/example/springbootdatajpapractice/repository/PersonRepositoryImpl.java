package com.example.springbootdatajpapractice.repository;

import com.example.springbootdatajpapractice.model.Person;
import com.example.springbootdatajpapractice.model.PersonId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class PersonRepositoryImpl implements CustomizedPersonRepository {

    private final CustomizedPersonRepository customizedPersonRepository;

    @Autowired
    protected PersonRepositoryImpl(CustomizedPersonRepository customizedPersonRepository) {
        this.customizedPersonRepository = customizedPersonRepository;
    }

    @Override
    public Person save(Person person) {
        return customizedPersonRepository.save(person);
    }

    @Override
    public Optional<Person> findById(PersonId personId) {
        return customizedPersonRepository.findById(personId);
    }

    @Override
    public List<Person> findAll() {
        return customizedPersonRepository.findAll();
    }

    @Override
    public void deleteById(PersonId id) {
        customizedPersonRepository.deleteById(id);
    }

    @Override
    public List<Person> findPersonByCityOfLiving(String city) {
        customizedPersonRepository.findPersonByCityOfLiving(city);
        return new ArrayList<>();
    }

    @Override
    public List<Person> findPersonByPersonIdAgeLessThanOrderByPersonId(int age) {
        customizedPersonRepository.findPersonByPersonIdAgeLessThanOrderByPersonId(age);
        return new ArrayList<>();
    }

    @Override
    public List<Person> findPersonByPersonId_FirstnameAndPersonId_Surname(Optional<String> firstname, Optional<String> surname) {
        customizedPersonRepository.findPersonByPersonId_FirstnameAndPersonId_Surname(firstname, surname);
        return new ArrayList<>();
    }
}
