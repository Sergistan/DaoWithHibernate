package com.example.daowithhibernate.service;

import com.example.daowithhibernate.model.Person;
import com.example.daowithhibernate.repositories.CrudPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudService {

    private final CrudPersonRepository crudPersonRepository;

    @Autowired
    public CrudService(CrudPersonRepository crudPersonRepository) {
        this.crudPersonRepository = crudPersonRepository;
    }

    public List<Person> getPersonsByCity(String city) {
        return crudPersonRepository.findPersonByCityOfLivingIgnoreCase(city);
    }

    public List<Person> getPersonsByAge(int age) {
        return crudPersonRepository.findPersonByAgeLessThanOrderByAgeAsc(age);
    }

    public Person getPersonsByNameAndSurname(String name, String surname) throws RuntimeException {
        Optional<Person> listPersons = crudPersonRepository.findPersonByNameIgnoreCaseAndSurnameIgnoreCase(name, surname);
        if (listPersons.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        return listPersons.get();
    }

    public List<Person> findAll() {
        return crudPersonRepository.findAll();
    }

}
