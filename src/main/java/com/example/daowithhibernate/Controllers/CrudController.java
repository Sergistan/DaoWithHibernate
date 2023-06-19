package com.example.daowithhibernate.Controllers;

import com.example.daowithhibernate.Model.Person;
import com.example.daowithhibernate.Service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CrudController {

    private CrudService crudService;

    @Autowired
    public CrudController(CrudService crudService) {
        this.crudService = crudService;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return crudService.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam int age) {
        return crudService.getPersonsByAge(age);
    }

    @GetMapping("/persons/by-name-surname")
    public Person getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return crudService.getPersonsByNameAndSurname(name, surname);
    }
}
