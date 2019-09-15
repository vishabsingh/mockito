package com.vs.mock.java8.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLevels {
    public static void main(String[] args) {

        Stream.of("vishab","singh","shell","test","hello", "vishab") //source
        .filter(s -> s.startsWith("v") || s.startsWith("s") && s.length() >= 6) // intermediate  operation
        .map(String::toUpperCase) // intermediate  operation
        .sorted((s1,s2) -> s2.compareTo(s1))  // intermediate  operation
        .distinct() // intermediate  operation
        .forEach(System.out::println); //  terminal operation

        int withSum = Stream.of("1", "2", "3", "4", "5")
                .mapToInt(Integer::valueOf)
                .sum();
        System.out.println("With Sum  : "+withSum);

        int reduce = Stream.of("1", "2", "3", "4", "5")
                .mapToInt(Integer::valueOf)
                .reduce(0,(x,y) -> x+y);
        System.out.println("With Reduce : "+reduce);

        String joinString = Stream.of("V","I","S","H","A","B")
                .collect(Collectors.joining());
        System.out.println("Join String : "+joinString);

        String joinStringWithReduce = Stream.of("V","I","S","H","A","B")
                .reduce("",(a,b) ->a+b);
        System.out.println("Join With Reduce "+joinStringWithReduce);
    }
}
