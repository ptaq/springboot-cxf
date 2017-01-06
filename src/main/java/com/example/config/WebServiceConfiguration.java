package com.example.config;

import com.example.dao.impl.PersonDaoImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Created by Grzegorz Śladowski on 2017-01-06.
 */
@Configuration
public class WebServiceConfiguration {

    @Bean
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/cxf/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Autowired
    private PersonDaoImpl personDaoImpl;
    @Bean
    public Endpoint usersEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), personDaoImpl);
        endpoint.publish("/test");
        return endpoint;
    }





}
