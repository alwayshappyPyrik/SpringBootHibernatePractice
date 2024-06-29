package com.example.springbootdatajpapractice.repository;

import com.example.springbootdatajpapractice.model.Person;
import com.example.springbootdatajpapractice.model.PersonId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

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
    // JPQL not supported insert (only hql or native query supported insert :( )
    public Person save(Person person) {
        return customizedPersonRepository.save(person);
    }

    @Override
    @Query("select p from persons p where p.personId.firstname = ?1 and p.personId.surname = ?2 and p.personId.age = ?3")
    public Optional<Person> findById(PersonId personId) {
        return customizedPersonRepository.findById(personId);
    }

    @Override
    @Query("select '*' from persons p where p.personId.firstname = ?1 and p.personId.surname = ?2 and p.personId.age = ?3")
    public List<Person> findAll() {
        return customizedPersonRepository.findAll();
    }

    @Override
    @Modifying
    @Query("delete from persons p where p.personId.firstname = ?1 and p.personId.surname = ?2 and p.personId.age = ?3")
    public void deleteById(PersonId id) {
        customizedPersonRepository.deleteById(id);
    }

    @Override
    @Query("select '*' from persons p where p.cityOfLiving = ?1")
    public List<Person> findPersonByCityOfLiving(String city) {
        customizedPersonRepository.findPersonByCityOfLiving(city);
        return new ArrayList<>();
    }

    @Override
    @Query("select '*' from persons p where p.personId.age < ?1 order by p.personId.age, p.personId.firstname, p.personId.surname")
    public List<Person> findPersonByPersonIdAgeLessThanOrderByPersonId(int age) {
        customizedPersonRepository.findPersonByPersonIdAgeLessThanOrderByPersonId(age);
        return new ArrayList<>();
    }

    @Override
    @Query("select '*' from persons p where p.personId.firstname = ?1 and p.personId.surname = ?2")
    public List<Person> findPersonByPersonId_FirstnameAndPersonId_Surname(Optional<String> firstname, Optional<String> surname) {
        customizedPersonRepository.findPersonByPersonId_FirstnameAndPersonId_Surname(firstname, surname);
        return new ArrayList<>();
    }
}
