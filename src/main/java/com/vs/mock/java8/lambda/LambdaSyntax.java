package com.vs.mock.java8.lambda;


import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaSyntax {
    public static void main(String[] args) {
        Function<Integer,Boolean> res = (number) -> number % 2 !=0 ;
        Predicate<Integer> isEven = (n) -> n % 2 == 0;
        BinaryOperator<String> concatString = (s1,s2) -> s1.concat(s2);
        Callable<Integer> callMe = () -> 42;

        // FILTERING
        Collection<Integer> collection = Arrays.asList(1,2,3,4,5,6,7,8,9);
        collection = filter((n) -> n %2 !=0,collection);
        System.out.println(" collections "+collection);
    }

    public static <T> Collection<T> filter(Predicate<T> predicate, Collection<T> collection) {
        Collection<T> filterCollections = new ArrayList();
        for(T t1 : collection){
            if(predicate.test(t1)){
                filterCollections.add(t1);
            }
        }
        return filterCollections;
    }
}

class LambdaTest {
    private Integer insVar1 = 20;
    public void publicMethod() {
        Thread t = new Thread(() -> System.out.println(insVar1));
        t.start();
        List<String> list = Arrays.asList("A", "B", "C");
        Collections.sort(list, (p1, p2) -> p1.compareTo(p2));
        list.forEach(x -> System.out.println(x));
    }
}
// COMPLIED CODE
/**
 * private java.lang.Integer insVar1;
 *   public com.java8exploration.LambdaTest();
 *     Code:
 *        ...
 *   public void publicMethod();
 *     Code:
 *       ...
 *       11: invokedynamic #5,  0              // InvokeDynamic #0:run:(Lcom/java8exploration/LambdaTest;)Ljava/lang/Runnable;
 *       16: invokespecial #6                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
 *       ...
 *       48: invokedynamic #13,  0             // InvokeDynamic #1:compare:()Ljava/util/Comparator;
 *       53: invokestatic  #14                 // Method java/util/Collections.sort:(Ljava/util/List;Ljava/util/Comparator;)V
 *       ...
 *       57: invokedynamic #15,  0             // InvokeDynamic #2:accept:()Ljava/util/function/Consumer;
 *       62: invokeinterface #16,  2           // InterfaceMethod java/util/List.forEach:(Ljava/util/function/Consumer;)V
 *       67: return
 *   private static void lambda$publicMethod$2(java.lang.String);
 *     Code:
 *        ...
 *   private static int lambda$publicMethod$1(java.lang.String, java.lang.String);
 *     Code:
 *        ...
 *   private void lambda$publicMethod$0();
 *     Code:
 *        ...
 * }
 */
