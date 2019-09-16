package com.vs.mock.java8.predicatefunction;

import com.vs.mock.java8.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionJava8 {
    public static void main(String[] args) {
        List<Customer> listOfCustmers =
            Arrays.asList(new Customer("Tom Jones", 45),
                new Customer("Harry Major", 25),
                new Customer("Ethan Hardy", 65),
                new Customer("Nancy Smith", 15),
                new Customer("Deborah Sprightly", 29));

        functionApply(listOfCustmers);
        functionCompose(listOfCustmers);
    }

    private static void functionCompose(List<Customer> listOfCustmers) {
        Function<Customer,String> nameFunction = (data) -> { return data.getName(); };

        Function<Customer,Customer> customerFunction = (data) -> {
            int index = data.getName().indexOf(" ");
            data.setName(data.getName().substring(0,index));
            return data;
        };
        System.out.println(extractFunction(listOfCustmers,nameFunction.compose(customerFunction)));
    }


    public static void functionApply(List<Customer> listOfCustmers) {
        Function<Customer,String> nameFunction = (data) -> { return data.getName(); };
        Function<Customer,Integer> ageFunction = (data) -> { return data.getAge(); };

        System.out.println(extractFunction(listOfCustmers,nameFunction));
        System.out.println(extractFunction(listOfCustmers,ageFunction));

        System.out.println("=============== THEN APPLY ==============");
        Function<String,String> intitalFunction = (data) -> data.substring(0,1);
        System.out.println(extractFunction(listOfCustmers,nameFunction.andThen(intitalFunction)));
        System.out.println(extractFunction(listOfCustmers,ageFunction.andThen((data)-> data > 25)));

    }

    private static <T, R> List<R> extractFunction(List<T> listOfCustmers, Function<T,R> genricFunction) {
        List<R> listResult = new ArrayList<>();
        listOfCustmers.forEach(items -> {
            listResult.add(genricFunction.apply(items));
        });
        return listResult;
    }
}
