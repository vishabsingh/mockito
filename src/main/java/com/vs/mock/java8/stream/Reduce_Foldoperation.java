package com.vs.mock.java8.stream;

import java.util.stream.Stream;

public class Reduce_Foldoperation {

    public static void main(String[] args) {
        System.out.println(
                Stream.of(1, 2, 3, 4, 5).reduce(0, (a, b) -> {
                    System.out.println("In accumulator: " + a + ", " + b);
                    return a + b;
                }, (a, b) -> {
                    System.out.println("In combiner: " + a + ", " + b);
                    return a + b;
                }));
        // Now Combiner is executed
        System.out.println(
                Stream.of(1, 2, 3, 4, 5).parallel().reduce(0, (a, b) -> {
                    System.out.println("In accumulator: " + a + ", " + b);
                    return a + b;
                }, (a, b) -> {
                    System.out.println("In combiner: " + a + ", " + b);
                    return a + b;
                }));
    }
}
