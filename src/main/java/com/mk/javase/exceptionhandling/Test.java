package com.mk.javase.exceptionhandling;

public class Test {

    public static void main(String[] args) {
        String a = null;
        try {
            System.out.println(a.toUpperCase());
        }catch (NullPointerException ne){
            System.out.println(ne);
        }
    }
}
