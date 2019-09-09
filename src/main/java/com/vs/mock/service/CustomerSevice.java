package com.vs.mock.service;

import com.vs.mock.modal.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerSevice {
    boolean addCustomer(Customer customer);
    public List<Customer> findAll();
    public Integer count();
    Optional<Customer> findById(Long id);
}
