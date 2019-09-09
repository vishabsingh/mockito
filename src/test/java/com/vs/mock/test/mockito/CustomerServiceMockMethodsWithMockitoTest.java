package com.vs.mock.test.mockito;

import com.vs.mock.dao.CustomerDao;
import com.vs.mock.modal.Customer;
import com.vs.mock.service.impl.CustomerServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
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
        Customer customer = new Customer(1l,"TESTUSER",95903192);
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

        Customer customer = new Customer(2l,"VISHAB",239804823);
        assertThat(customerSevice.addCustomer(customer), is(notNullValue()));
    }

    //Throwing an exception from the mocked method
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

        verify(customerDao.save(any(Customer.class)) , times(1));
    }
}
