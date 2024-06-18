package com.example.springbootdatajpapractice;

import com.example.springbootdatajpapractice.model.Person;
import com.example.springbootdatajpapractice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDataJpaPracticeApplication implements CommandLineRunner {

    private final PersonRepository personRepository;

    @Autowired
    public SpringBootDataJpaPracticeApplication(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataJpaPracticeApplication.class, args);
    }

    @Override
    public void run(String... args) {
        personRepository.save(new Person("Yaroslav", "Pyrikov", 31, "", "Moscow"));
        personRepository.save(new Person("Vasiliy", "Ogurсhov", 31, "", "moscow"));
        personRepository.save(new Person("Roberto", "Carlos", 40, "", "Brazil"));
        personRepository.save(new Person("Vania", "Poddupniy", 1, "", "Volgograd"));
    }
}
