package com.example.config;

import com.example.contractfirstImpl.ContractFirstImpl;
import com.example.dao.impl.PersonDaoImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Created by Grzegorz Śladowski on 2017-01-06.
 */
@Configuration
public class WebServiceConfiguration  {

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Autowired
    private PersonDaoImpl personDaoImpl;

    @Autowired
    private ContractFirstImpl contractFirst;

    @Bean
    public Endpoint usersEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), personDaoImpl);
        endpoint.publish("/test");
        return endpoint;
    }


    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), contractFirst);
        endpoint.publish("/test2");
        return endpoint;
    }






}
