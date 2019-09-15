package com.vs.mock.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectStream {
    public static void main(String[] args) {

        /**
         * R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
         */
        List<String> x1 = Stream.of("R", "O", "B", "I", "N")
                .collect(
                            () -> new ArrayList<>(),
                            (a,e) -> {
                                System.out.println("in accumulator : "+a + " , "+e);
                                a.add(e.toLowerCase());
                            },
                            (a,e) -> {
                                System.out.println("In combiner: " + a + ", " + e);
                                a.addAll(e);
                            }
                        );
        System.out.println(""+x1);

        List<String> x2 = Stream.of("R", "O", "B", "I", "N").parallel()
                .collect(() -> new ArrayList<>(), (a, e) -> {
                    System.out.println("In accumulator: " + a + ", " + e);
                    a.add(e.toLowerCase());
                }, (a, e) -> {
                    System.out.println("In combiner: " + a + ", " + e);
                    a.addAll(e);
                });
        System.out.println("parllel stream  "+x2);

        Stream.of("R", "O", "B")
                .filter(e-> {
                    System.out.println("");
                    System.out.print("In filter: " + e + " -> ");
                    return e.equalsIgnoreCase("R");
                })
                .map(e -> {
                    System.out.print("In map: " + e +" -> ");
                    return e.toLowerCase();
                })
                .forEach(e -> {
                    System.out.print("In forEach: " + e);
                });

        System.out.println("======== SORTED ========");
        Stream.of("R", "O", "B")
                .sorted((a,b)->{
                    System.out.println("sorted: " + b + a);
                    return a.compareTo(b);
                })
                .forEach(e -> System.out.println("forEach: " + e));
    }
}
