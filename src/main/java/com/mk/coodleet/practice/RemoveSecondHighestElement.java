package com.mk.coodleet.practice;

import java.util.*;

public class RemoveSecondHighestElement {
    private void removeSecondHighest(HashMap<String, Integer> map){
        ArrayList<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, Collections.reverseOrder());
        Integer secondHighestValue = values.get(1);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue().equals(secondHighestValue)){
                map.remove(entry.getKey());
                return;
            }
        }
    }

    public static void main(String[] args) {
        RemoveSecondHighestElement remove = new RemoveSecondHighestElement();
        HashMap<String, Integer> studentGrade = new HashMap<>();
        studentGrade.put("Mya Mya", 60);
        studentGrade.put("Hla Hla", 70);
        studentGrade.put("Si Si", 80);
        studentGrade.put("Mi Mi", 90);
        System.out.println("Before remove : "+ studentGrade);
        remove.removeSecondHighest(studentGrade);
        System.out.println("After remove : "+ studentGrade);
        System.out.println("-----------------");

        HashMap<String, Integer> studentAge = new HashMap<>();
        studentAge.put("Mya Mya", 10);
        studentAge.put("Hla Hla", 11);
        studentAge.put("Si Si", 12);
        studentAge.put("Mi Mi", 13);
        System.out.println("Before remove : "+ studentAge);
        remove.removeSecondHighest(studentAge);
        System.out.println("After remove : "+ studentAge);
    }
}
