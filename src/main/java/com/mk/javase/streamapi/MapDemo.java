package com.mk.javase.streamapi;

import com.mk.javase.generic.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
    return only one value but want to return two values use Obj
 */
public class MapDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Orange");
        list.add("Grape");
        list.add("Watermelon");

        Stream<String> strLowerCaseStream = list
                .stream()
                .map(item -> item.toLowerCase());
        strLowerCaseStream.forEach(System.out::println);

        Stream<Pair<String, Integer>> pairStream = list
                .stream()
                .map(item -> new Pair(item.toLowerCase(), item.length()));
        pairStream.forEach(pair -> {
            System.out.println("String : "+ pair.getFirst()+ " ---- Length : "+ pair.getSecond());
        });

        // requirement length is 6
        Stream<Pair<String, Integer>> pairStream1 = list
                .stream()
                .map(item -> new Pair<String, Integer>(item.toLowerCase(), item.length()))
                .filter(pair -> pair.getSecond() == 6); // Pair obj become pair
        //convert Stream to List
        List<Pair<String,Integer>> list1 = pairStream1.collect(Collectors.toList());
        list1.forEach(pair -> {
            System.out.println("pairStream1 String : "+ pair.getFirst()+ " ---- Length : "+ pair.getSecond());
        });
    }
}
