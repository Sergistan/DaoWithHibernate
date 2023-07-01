package com.example.daowithhibernate.controllers;

import com.example.daowithhibernate.model.Person;
import com.example.daowithhibernate.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class CrudController {

    private CrudService crudService;

    @Autowired
    public CrudController(CrudService crudService) {
        this.crudService = crudService;
    }

    @GetMapping("/by-city")
    @Secured("ROLE_READ")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return crudService.getPersonsByCity(city);
    }

    @GetMapping("/by-age")
    @RolesAllowed("ROLE_WRITE")
    public List<Person> getPersonsByAge(@RequestParam int age) {
        return crudService.getPersonsByAge(age);
    }

    @GetMapping("/by-name-surname")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public Person getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return crudService.getPersonsByNameAndSurname(name, surname);
    }

    @GetMapping("/find-all")
    @PreAuthorize("#username == authentication.principal.username")
    public List<Person> findAll(@RequestParam String username) {
        return crudService.findAll();
    }
}
