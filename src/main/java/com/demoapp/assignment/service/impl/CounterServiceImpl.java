package com.demoapp.assignment.service.impl;

import com.demoapp.assignment.dao.CounterDao;
import com.demoapp.assignment.model.Counter;
import com.demoapp.assignment.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterServiceImpl implements CounterService {
    @Autowired
    public CounterDao counterDao;

    @Override
    public Counter incrementCounter(String name) {
        return counterDao.increment(name);
    }

    @Override
    public Counter getCounter(String name) {
        return counterDao.findOne(name);
    }

    @Override
    public List<Counter> getAllCounters() {
        return counterDao.findAll();
    }

    @Override
    public Counter saveCounter(Counter counter) {
        return counterDao.save(counter);
    }
}
