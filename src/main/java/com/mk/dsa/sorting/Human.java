package com.mk.dsa.sorting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//Object Sort
@Getter
@Setter
@AllArgsConstructor
public class Human implements Comparable<Human>{
    private String name;
    private int age;

    /*
        = -> 0
        > -> 1
        < -> -1
        In Math, compare two 5 -5 = 0, 5-4=1 , 5-6= -1 see
     */
    @Override
    public int compareTo(Human another) {
        return this.age - another.age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
