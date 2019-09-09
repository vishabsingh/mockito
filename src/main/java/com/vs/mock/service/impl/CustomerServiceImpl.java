package com.vs.mock.service.impl;

import com.vs.mock.dao.CustomerDao;
import com.vs.mock.modal.Customer;
import com.vs.mock.service.CustomerSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerServiceImpl implements CustomerSevice {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean addCustomer(Customer customer) {
        boolean result = customerDao.exits(customer.getPhoneNumber()) ? false : customerDao.save(customer);
        System.out.println(" addCustomer() --> "+result);
        return result;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = customerDao.findAll();
        System.out.println("### LIST : "+list);
        return list;
    }

    @Override
    public Integer count() {
        return customerDao.count();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerDao.findById(id);
    }


}
