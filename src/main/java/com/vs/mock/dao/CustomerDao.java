package com.vs.mock.dao;

import com.vs.mock.modal.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    boolean save(Customer customer);

    boolean exits(Integer phoneNumber);

    Optional<Customer> findById(Long id);

    List<Customer> findAll();

    Integer count();
}
