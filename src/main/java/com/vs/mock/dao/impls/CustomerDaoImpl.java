package com.vs.mock.dao.impls;

import com.vs.mock.dao.CustomerDao;
import com.vs.mock.modal.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean save(Customer customer) {
        return customer !=null && customer.getId() !=null ? true : false;
    }

    @Override
    public boolean exits(Integer phoneNumber) {
        return phoneNumber !=null ? true : false;
    }
}
