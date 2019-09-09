package com.vs.mock.service.impl;

import com.vs.mock.dao.CustomerDao;
import com.vs.mock.modal.Customer;
import com.vs.mock.service.CustomerSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class CustomerServiceImpl implements CustomerSevice {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean addCustomer(Customer customer) {
        boolean result = customerDao.exits(customer.getPhoneNumber()) ? false : customerDao.save(customer);
        System.out.println(" addCustomer()     "+result);
        return result;
    }
}
