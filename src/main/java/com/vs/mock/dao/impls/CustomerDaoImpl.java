package com.vs.mock.dao.impls;

import com.vs.mock.dao.CustomerDao;
import com.vs.mock.modal.Customer;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomerDaoImpl implements CustomerDao {

    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1l,"A",12345));
        customers.add(new Customer(2l,"B",22222));
        customers.add(new Customer(3l,"C",33333));
        customers.add(new Customer(4l,"D",44444));
    }
    @Override
    public boolean save(Customer customer) {
        return customer !=null && customer.getId() !=null ? customers.add(customer) : false;
    }

    @Override
    public boolean exits(Integer phoneNumber) {
        return phoneNumber !=null ? customers.stream().filter(data -> data.getPhoneNumber().equals(phoneNumber)).findFirst().isPresent() : false;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        Optional<Customer> result = customers.stream().filter(data -> data.getId()== id).findFirst();
        return id !=null ? result : Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        return !customers.isEmpty() ? customers : Collections.emptyList();
    }

    @Override
    public Integer count() {
        return customers.size();
    }


}
