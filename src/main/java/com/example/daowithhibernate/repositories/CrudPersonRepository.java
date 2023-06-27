package com.example.daowithhibernate.repositories;

import com.example.daowithhibernate.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudPersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findPersonByCityOfLivingIgnoreCase(String cityOfLiving);

    List<Person> findPersonByAgeLessThanOrderByAgeAsc(int age);

    Optional<Person> findPersonByNameIgnoreCaseAndSurnameIgnoreCase(String name, String surname);
}