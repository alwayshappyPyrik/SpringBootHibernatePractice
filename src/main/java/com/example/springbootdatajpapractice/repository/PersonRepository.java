package com.example.springbootdatajpapractice.repository;

import com.example.springbootdatajpapractice.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Person save(Person person) {
        entityManager.persist(person);
        return person;
    }

    public List<Person> getPersonsByCity(String city) {
        TypedQuery<Person> persons = entityManager.createQuery("select p from persons p where lower(p.cityOfLiving) = lower(:city)", Person.class);
        persons.setParameter("city", city);
        return persons.getResultList();
    }
}
