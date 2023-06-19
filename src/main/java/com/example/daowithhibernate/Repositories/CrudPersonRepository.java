package com.example.daowithhibernate.Repositories;

import com.example.daowithhibernate.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudPersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findPersonByCityOfLivingIgnoreCase(String cityOfLiving);

    List<Person> findPersonByAgeLessThanOrderByAgeAsc(int age);

    Optional<List<Person>> findPersonByNameIgnoreCaseAndSurnameIgnoreCase(String name, String surname);
}
