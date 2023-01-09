package com.demoapp.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

@Component
public class RestExceptionHandler extends RuntimeException implements ExceptionMapper<CounterNotFoundException> {
    @Override
    public Response toResponse(CounterNotFoundException ex) {
        return Response.status(HttpStatus.NOT_FOUND.value()).entity(ex.getMessage()).type("text/plain").build();
    }
}
