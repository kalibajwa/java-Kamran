package com.demoapp.assignment.model;

import java.util.Objects;

public class Counter {
    private String name;
    private Integer count;

    public Counter() {
    }

    public Counter(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Counter counter = (Counter) o;
        return Objects.equals(name, counter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
