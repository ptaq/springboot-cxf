package com.example.repository;

import com.example.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Grzegorz Śladowski on 2017-01-04.
 */
public interface PersonRepository extends CrudRepository<Person,Long> {

    @Query(value = "SELECT SUM(a.salary) FROM Person a ")
    String sumSal();




}
