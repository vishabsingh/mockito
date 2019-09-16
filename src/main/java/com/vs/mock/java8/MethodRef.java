package com.vs.mock.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MethodRef {

    Optional<List<String>> names;

    public void toLowerCase(String s){
        System.out.print(s.toLowerCase());
    }

    public static void toUpperCase(String s){
        System.out.print(s.toUpperCase());
    }

    public static void main(String[] args) {
        MethodRef methodRef = new MethodRef();
        List<String> list = Arrays.asList("A", "B", "C");
        list.forEach(methodRef::toLowerCase);
        list.forEach(MethodRef::toUpperCase);
        methodRef.testMethodREf();
    }

    private void testMethodREf() {
        List<String> list = Arrays.asList("A", "B", "C");
        list.forEach(String::new);
    }
}
