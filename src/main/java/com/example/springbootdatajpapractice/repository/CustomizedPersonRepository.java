package com.example.springbootdatajpapractice.repository;

import com.example.springbootdatajpapractice.model.Person;
import com.example.springbootdatajpapractice.model.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomizedPersonRepository extends JpaRepository<Person, PersonId> {
    Person save(Person person);

    Optional<Person> findById(PersonId personId);

    List<Person> findAll();

    void deleteById(PersonId id);

    List<Person> findPersonByCityOfLiving(String city);

    List<Person> findPersonByPersonIdAgeLessThanOrderByPersonId(int age);

    List<Person> findPersonByPersonId_FirstnameAndPersonId_Surname(Optional<String> firstname, Optional<String> surname);
}


