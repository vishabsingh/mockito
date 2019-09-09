package com.vs.mock.dao;

import com.vs.mock.modal.Customer;

public interface CustomerDao {

    boolean save(Customer customer);

    boolean exits(Integer phoneNumber);
}
