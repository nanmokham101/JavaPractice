package com.mk.javase.wrapper;

public class WrapperProblem {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        System.out.println("a == b : " + (a == b)); // check with Reference Equality . Same Object cast with String

        Integer c = 128; // -128 to 127 only cast , if over 127 create new Object
        Integer d = 127;
        System.out.println("c == d : " + (c == d)); // not to check Reference Equality, use .equal()
    }
}
