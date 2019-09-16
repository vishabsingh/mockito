package com.vs.mock.java8.methodref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
 * http://ocpj8.javastudyguide.com/ch01.html
 *
 * (args) -> new ClassName(args)
 * ClassName::new
 *
 * The only thing this lambda expression does is to create a new object and
 * we just reference a constructor of the class with the keyword new.
 * Like in the other cases, arguments (if any) are not passed in the method reference.
 */
public class ConstructorMethodReference {
    public static void main(String[] args) {

        /**
         *If the constructor takes no arguments, a Supplier will do the job:
         */
        Supplier<List<String>> supplier = new Supplier<List<String>>() {
            @Override
            public List<String> get() {
                return new ArrayList<>();
            }
        };
        Supplier<List<String>> supplier1 = () -> new ArrayList<>();
        Supplier<List<String>> supplier2 = ArrayList::new;

        /**
         * If the constructor takes an argument, we can use the Function interface
         */
        Function<String,Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return new Integer(s);
            }
        };
        Integer integer = function.apply("100");
        Function<String,Integer> function1 = (s) -> new Integer(s);
        Integer integer1 = function1.apply("200");
        Function<String,Integer> function2 = Integer::new;
        Integer integer2 = function2.apply("300");

        /**
         * If the constructor takes two arguments, we use the BiFunction interface:
         */
        // ANONYOMUS
        BiFunction<String,String, Locale> biFunction = new BiFunction<String, String, Locale>() {
            @Override
            public Locale apply(String lang, String country) {
                return new Locale(lang,country);
            }
        };
        System.out.println(biFunction.apply("en","UK"));
        BiFunction<String,String,Locale> biFunction1 = (s1,s2) -> new Locale(s1,s2);
        System.out.println(biFunction.apply("en","IND"));
        BiFunction<String,String,Locale> biFunction2 = Locale::new;
        System.out.println(biFunction2.apply("en","USA"));

        /**
         * If you have a constructor with three or more arguments, you would have to create your own functional interface.
         */

    }
}
