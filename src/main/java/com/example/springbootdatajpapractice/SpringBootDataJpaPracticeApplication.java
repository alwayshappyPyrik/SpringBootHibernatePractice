package com.example.springbootdatajpapractice;

import com.example.springbootdatajpapractice.model.Person;
import com.example.springbootdatajpapractice.model.PersonId;
import com.example.springbootdatajpapractice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDataJpaPracticeApplication implements CommandLineRunner {

    private final PersonService personService;

    @Autowired
    public SpringBootDataJpaPracticeApplication(PersonService personService) {
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataJpaPracticeApplication.class, args);
    }

    @Override
    public void run(String... args) {
        personService.save(new Person(new PersonId("Yaroslav", "Pyrikov", 31), "", "Moscow"));
        personService.save(new Person(new PersonId("Vasiliy", "Ogurсhov", 31), "", "moscow"));
        personService.save(new Person(new PersonId("Roberto", "Carlos", 40), "", "Brazil"));
        personService.save(new Person(new PersonId("Vania", "Poddupniy", 1), "", "Volgograd"));
    }
}
