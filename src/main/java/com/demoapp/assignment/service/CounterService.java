package com.demoapp.assignment.service;

import com.demoapp.assignment.model.Counter;

import java.util.List;

public interface CounterService {
    /**
     * Increment the counter
     * @param name
     * @return Counter
     */
    Counter incrementCounter(String name);

    /**
     * Get the counter
     * @param name
     * @return Counter
     */
    Counter getCounter(String name);

    /**
     * Get all couners
     * @return List<Counter>
     */
    List<Counter> getAllCounters();

    /**
     * Save the counter
     * @param counter
     * @return Counter
     */
    Counter saveCounter(Counter  counter);
}
