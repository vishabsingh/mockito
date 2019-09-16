package com.vs.mock.java8.methodref;

import com.vs.mock.java8.Customer;

import java.util.function.Consumer;

public class MethodRefApp2 {

    public void getCustomers(Customer customer){
            System.out.println(customer);
    }

    public void execute(Customer customer, Consumer<Customer> consumer){
        consumer.accept(customer);
    }

    public static void main(String[] args) {

        MethodRefApp2 methodRefApp2 = new MethodRefApp2();
        Customer customer = new Customer("TEST",23,"J&K");

        // Using an anonymous class
        methodRefApp2.execute(customer, new Consumer<Customer>() {
            @Override
            public void accept(Customer customer) {
                methodRefApp2.getCustomers(customer);
            }
        });

        methodRefApp2.execute(customer,data -> methodRefApp2.getCustomers(data));

        methodRefApp2.execute(customer,methodRefApp2::getCustomers);
    }
}
