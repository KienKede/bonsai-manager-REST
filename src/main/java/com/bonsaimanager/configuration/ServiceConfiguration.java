package com.bonsaimanager.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.bonsaimanager.backend.service" })
public class ServiceConfiguration {

    public ServiceConfiguration() {
        super();
    }

    // beans

}
