package com.vs.mock.java8.methodref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class MethodRefApp {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(12,5,45,18,33,24,40);
        // Using an anonymous class
        List<Integer> anonymus = findNumbers(list, new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer integer, Integer integer2) {
                System.out.println(this);
                return MethodRefApp.isMoreThanFity(integer,integer2);
            }

           @Override
           public String toString() {
               return "BiPredicate Class CurrentRef  ";
           }
       });
       System.out.println(anonymus);

       // Using Lambda Expression
        List<Integer> lambda = findNumbers(list,(a,b) -> MethodRefApp.isMoreThanFity(a,b));
        System.out.println(lambda);

        // Using a method reference
        List<Integer> methodRef = findNumbers(list,MethodRefApp::isMoreThanFity);
        System.out.println(methodRef);

    }

    public static List<Integer> findNumbers(List<Integer> l, BiPredicate<Integer,Integer> p) {
        List<Integer> resultList = new ArrayList<>();
        l.stream().forEach(integer -> {
            if(p.test(integer, integer+10)) {
                resultList.add(integer);
            }
        });
        return resultList;
    }

    private static boolean isMoreThanFity(int i, int i1) {
        return  (i + i1) > 50;
    }

}

