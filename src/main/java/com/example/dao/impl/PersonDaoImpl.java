package com.example.dao.impl;


import com.example.dao.PersonDao;
import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Grzegorz Śladowski on 2017-01-04.
 */
@Component
public class PersonDaoImpl implements PersonDao {


    private PersonRepository personRepository;

    @Autowired
    public PersonDaoImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public String update(Person person) {
        try {
            personRepository.save(person);
            //Jeżeli operacja zakończyła sie powodzeniem, wysyłamy kod 1
            return "1";
        } catch (Exception e) {
            //Jeśli wystąpił jakiś błąd należałoby wysłać odpowiedni numer błędu, w mojej
            //aplikacji błąd zawsze będzie miał wartość 2
            return "2";
        }

    }

    @Override
    public String create(Person person) {
        try {
            //zapobiega nadpisywaniu wartości
            if (personRepository.exists(person.getPersonId())) throw new Exception();
            else personRepository.save(person);
            return "1";
        } catch (Exception e) {
            return "2";
        }
    }


    @Override
    public String retrieve(Long id) {
        try {
            //zamiast kodu powodzenia zwracamy osobe wykorzystując metode toString
            return personRepository.findOne(id).toString();
        } catch (Exception e) {
            return "2";
        }

    }



    @Override
    public String delete(Long id) {
        try {
            personRepository.delete(id);
            return "1";
        } catch (Exception e) {
            return "2";
        }
    }

}
