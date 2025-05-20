package com.mk.javase.streamapi;

import java.util.ArrayList;
import java.util.Optional;

/*
    Reduce -> want to add all item in array -> take two element and add
           [1,2,3,4]
           (a,b) ->
           (1,2) -> 3
           [3,3,4]
           [6,4]
           [10]
        */
public class ReduceDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(2);
        list.add(28);
        list.add(6);
        list.add(9);
        list.add(13);
        list.add(11);
        // return one value so Optional
        Optional<Integer> sum = list
                .stream()
                .reduce((a,b) -> {
                    System.out.println("A : "+ a + "---- B : "+ b);
                    return a + b;
                });
        System.out.println("Sum -> "+ sum.get());

        // pair wise
        // (1,(a.b)) -> 1 is initial parameter to ok with any element to multiplied
        Optional<Integer> max = list
                .stream()
                .reduce((a,b) -> {
                    System.out.println("A : "+ a + "---- B : "+ b);
                    return (a > b) ? a : b;
                });
        System.out.println("Max -> "+ max.get());

        Optional<Integer> min = list
                .stream()
                .reduce((a,b) -> {
                    System.out.println("A : "+ a + "---- B : "+ b);
                    return (a > b) ? b : a;
                });
        System.out.println("Min -> "+ min.get());
    }
}
