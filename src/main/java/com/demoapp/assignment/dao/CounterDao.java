package com.demoapp.assignment.dao;

import com.demoapp.assignment.model.Counter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CounterDao {
    private static List<Counter> counterList = new ArrayList<>();

    static {
        counterList.add(new Counter("dumy",1));
    }

    /**
     * Increment the counter
     * @param name
     * @return Counter
     */
    public Counter increment(String name) {
        for (Counter counter: counterList){
            if(counter.getName().equals(name)){
                int newCount = counter.getCount() + 1;
                counter.setCount(newCount);
                return counter;
            }
        }
        return null;
    }

    /**
     * Save/Update the counter
     * @param counter
     * @return Counter
     */
    public Counter save(Counter counter) {
        boolean alreadExists = false;
        for (Counter c: counterList){
            if(c.getName().equals(counter.getName())){
                alreadExists = true;
                int newCount = c.getCount() + 1;
                c.setCount(newCount);
                return c;
            }
        }
        if(!alreadExists){ // if it does not already exists
            counterList.add(counter);
        }
        return counter;
    }

    /**
     * Find/Get a counter
     * @param name
     * @return Counter
     */
    public Counter findOne(String name) {
        for (Counter counter: counterList){
            if(counter.getName().equals(name)){
                return counter;
            }
        }
        return null;
    }

    /**
     * Find/Get all couners
     * @return List<Counter>
     */
    public List<Counter> findAll(){
        return counterList;
    }


}
