package com.vs.mock.modal;


public class Customer {
    private Long id;
    private String name;
    private Integer phoneNumber;

    public Customer() {

    }

    public Customer(Long id, String name, Integer phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer ID "+this.id + " Name : "+this.name + " PhoneNumber : "+this.phoneNumber;
    }
}
