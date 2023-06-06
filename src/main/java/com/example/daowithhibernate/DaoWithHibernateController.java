package com.example.daowithhibernate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DaoWithHibernateController {
    private DaoWithHibernateRepository daoWithHibernateRepository;

    public DaoWithHibernateController(DaoWithHibernateRepository daoWithHibernateRepository) {
        this.daoWithHibernateRepository = daoWithHibernateRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city){
        return daoWithHibernateRepository.getPersonsByCity(city);
    }
}
