package com.vs.mock.java8.predicatefunction;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateDemo {
  public static void main(String[] args) {
    Object[] numbers = {1,2,3,4,5,6,7,8,9};
    Stream stream = Stream.of(1,2,3,4,5,6,7,8,9).filter(((Predicate)  data -> (int) data % 2 == 0).negate());
    stream.forEach(System.out::println);

    // Second Option
    System.out.println("==== Negate Second Option ====");
    Stream.of(numbers).filter(not(c -> (int)c % 2 == 0)).forEach(System.out::println);

  }
  public static <R> Predicate <R> not(Predicate<R> predicate){
    return  predicate.negate();
  }
}
