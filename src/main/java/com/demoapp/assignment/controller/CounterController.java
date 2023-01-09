package com.demoapp.assignment.controller;

import com.demoapp.assignment.exception.CounterNotFoundException;
import com.demoapp.assignment.model.Counter;
import com.demoapp.assignment.service.impl.CounterServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "counter-management")
@Path("/counter-management")
public class CounterController {
    @Autowired
    public CounterServiceImpl counterService;

    @GET
    @Path("/counters/{name}/increment")
    @Produces("application/json")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Counter has been icremented"),
            @ApiResponse(responseCode = "404", description = "Counter is not found")

    })
    public Response incrementCounter(@PathParam("name") String name) {

        Counter counter = counterService.incrementCounter(name);
        if (counter == null) {
            throw new CounterNotFoundException("Unable to find the counter with name: " + name);
        }
        return Response
                .status(HttpStatus.OK.value())
                .entity(counter).build();
    }

    @GET
    @Path("/counters/{name}")
    @Produces("application/json")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a counter"),
            @ApiResponse(responseCode = "404", description = "Counter is not found")

    })
    public Response getCounter(@PathParam("name") String name) {

        Counter counter = counterService.getCounter(name);
        if (counter == null) {
            throw new CounterNotFoundException("Unable to find the counter with name: " + name);
        }
        return Response
                .status(HttpStatus.OK.value())
                .entity(counter).build();
    }

    @GET
    @Path("/counters")
    @Produces("application/json")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return list of all counters"),
            @ApiResponse(responseCode = "404", description = "Counters are not found")

    })
    public Response getAllCounters() {
        List<Counter> counterList = counterService.getAllCounters();
        if (counterList == null) {
            counterList = new ArrayList<>();
        }
        return Response
                .status(HttpStatus.OK.value())
                .entity(counterList).build();
    }

    @POST
    @Path("/counters")
    @Produces("application/json")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Counter has been saved successfully"),
            @ApiResponse(responseCode = "404", description = "Counter is not found")

    })
    public Response saveCounter(Counter counter) {

        if (counter == null) {
            throw new CounterNotFoundException("Unable to find the counter");
        }

        Counter counterSaved = counterService.saveCounter(counter);
        return Response
                .status(HttpStatus.OK.value())
                .entity(counterSaved).build();
    }

}
