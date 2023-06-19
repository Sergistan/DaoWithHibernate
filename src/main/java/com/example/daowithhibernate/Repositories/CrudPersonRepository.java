package com.example.daowithhibernate.Repositories;

import com.example.daowithhibernate.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudPersonRepository extends JpaRepository<Person, Integer> {
    @Query("select e from Person as e where lower (e.cityOfLiving) = lower(:cityOfLiving)")
    List<Person> findPersonByCityOfLivingIgnoreCase(@Param ("cityOfLiving") String cityOfLiving);
    @Query("select e from Person as e where e.age < :age order by :age asc")
    List<Person> findPersonByAgeLessThanOrderByAgeAsc(@Param ("age") int age);
    @Query("select e from Person as e where lower (e.name) = lower(:name) " +
            "and lower (e.surname) = lower(:surname)")
    Optional<Person> findPersonByNameIgnoreCaseAndSurnameIgnoreCase(@Param ("name") String name,
                                                                          @Param ("surname") String surname);
}
