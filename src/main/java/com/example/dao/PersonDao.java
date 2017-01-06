package com.example.dao;

import com.example.model.Person;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by Grzegorz Śladowski on 2017-01-06.
 */
@WebService
public interface PersonDao {


    @WebMethod(operationName = "getPerson")
    public String retrieve(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "addPerson")
    public String create(@WebParam(name = "Person") Person person);

    @WebMethod(operationName = "uptadePerson")
    public String update(@WebParam(name = "Person")Person person);

    @WebMethod(operationName = "deletePerson")
    public String delete(@WebParam(name = "id")Long id);



}

