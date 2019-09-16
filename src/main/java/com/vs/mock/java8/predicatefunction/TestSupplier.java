package com.vs.mock.java8.predicatefunction;

import com.vs.mock.java8.Customer;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestSupplier {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
       supplietTest();
       consumerTest();
    }

    private static void consumerTest() {
        Consumer<String> consumer1 = (argument) -> {System.out.println(argument+ " !! ");};
        consumer1.accept("Consumer 1");
        Consumer<String> consumer2 = (cons2) -> {System.out.println(cons2 + "Consumer 2 ");};
        consumer1.andThen(consumer2).accept("Consumer After Then ");
    }

    private static void supplietTest() {
        Supplier<Customer> customerSupplier = () -> {
            return new Customer("VISHAB",29,"KATHUA");
        };
        Customer customer = customerSupplier.get();
        System.out.println(customer);
    }
}
