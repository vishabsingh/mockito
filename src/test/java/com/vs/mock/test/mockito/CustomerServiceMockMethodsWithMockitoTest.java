package com.vs.mock.test.mockito;

import com.vs.mock.dao.CustomerDao;
import com.vs.mock.modal.Customer;
import com.vs.mock.service.impl.CustomerServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CustomerServiceMockMethodsWithMockitoTest {

    @Mock
    private CustomerDao customerDao;

    @InjectMocks
    private CustomerServiceImpl customerSevice;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCustomer_ReturnsNewCustomer(){
        Customer customer = new Customer(5l,"TESTUSER",95903192);
        when(customerDao.save(customer)).thenReturn(true);
        //when(customerDao.save(any(Customer.class))).thenReturn(customer);
        assertThat(customerSevice.addCustomer(customer) , is(notNullValue()));
    }

    @Test
    @Ignore
    public void testAddCustomer_returnsNewCustomerWithId() {
        when(customerDao.save(any(Customer.class))).thenAnswer(new Answer<Customer>() {
            @Override
            public Customer answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] arguments = invocationOnMock.getArguments();
                if(arguments !=null && arguments.length > 0 && arguments[0] !=null){
                    System.out.println(Arrays.toString(arguments));
                    Customer customer = (Customer) arguments[0];
                    return customer;
                }
                return null;
            }
        });

        Customer customer = new Customer(6l,"VISHAB",239804823);
        assertThat(customerSevice.addCustomer(customer), is(notNullValue()));
    }

    @Test(expected = RuntimeException.class)
    public void testAddCustomer_throwsException() {
        when(customerDao.save(any(Customer.class))).thenThrow(RuntimeException.class);
        Customer customer = new Customer();
        customerSevice.addCustomer(customer);
    }

    @Test
    public void test_VoidMethodsWithMockito(){
        Customer customer = new Customer();
        when(customerDao.save(customer)).thenReturn(true);
        assertThat(customerSevice.addCustomer(customer), is(true));
        verify(customerDao , times(1)).save(any(Customer.class));
    }

    @Test
    public void test_Mockito(){
        Customer customer = new Customer(7l,"VISHAB",7724879);

        when(customerDao.save(customer)).thenReturn(true);
        assertThat(customerSevice.addCustomer(customer),is(true));

        when(customerDao.findById(7l)).thenReturn(Optional.of(customer));
        Optional<Customer> customerForDB  = customerSevice.findById(7l);
        Customer custorRes = customerForDB.get();
        verify(customerDao,times(1)).findById(7l);
        assertThat(custorRes.getId() ,is(customer.getId()));
        assertThat(custorRes.getName(), is("VISHAB"));

        when(customerDao.count()).thenReturn(7);
        assertThat(customerSevice.count(), is(7));

        List mockNameList = Mockito.mock(List.class);
        when(customerDao.findAll()).thenReturn(mockNameList);
        List<Customer> dbList = customerSevice.findAll();
        verify(customerDao).findAll();

        assertNotNull(dbList);
    }
}
