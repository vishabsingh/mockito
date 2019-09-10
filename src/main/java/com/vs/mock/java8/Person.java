package com.vs.mock.java8;

public class Person {

    private String name;
    private JobPosition currentJobPosition;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobPosition getCurrentJobPosition() {
        return currentJobPosition;
    }

    public void setCurrentJobPosition(JobPosition currentJobPosition) {
        this.currentJobPosition = currentJobPosition;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", currentJobPosition=" + currentJobPosition +
            '}';
    }
}
