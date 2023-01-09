package com.demoapp.assignment.config;

import com.demoapp.assignment.controller.CounterController;
import com.demoapp.assignment.exception.CounterNotFoundException;
import com.demoapp.assignment.exception.RestExceptionHandler;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.demoapp.assignment.controller");
        register(CounterNotFoundException.class);
        register(RestExceptionHandler.class);
        register(CounterController.class);
        register(OpenApiResource.class);
    }
}
