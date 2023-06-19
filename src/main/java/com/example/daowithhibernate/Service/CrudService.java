package com.example.daowithhibernate.Service;

import com.example.daowithhibernate.Model.Person;
import com.example.daowithhibernate.Repositories.CrudPersonRepository;
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

    public Optional<List<Person>> getPersonsByNameAndSurname(String name, String surname) {
        return crudPersonRepository.findPersonByNameIgnoreCaseAndSurnameIgnoreCase(name,surname);
    }
}
