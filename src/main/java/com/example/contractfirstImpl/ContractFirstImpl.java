package com.example.contractfirstImpl;

import com.example.contractfirst.ContractFirst;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Grzegorz Śladowski on 2017-01-12.
 */
@Component
public class ContractFirstImpl implements ContractFirst {

    private PersonRepository personRepository;

    @Autowired
    public ContractFirstImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public String sumSalary() {
        return personRepository.sumSal();
    }
}
