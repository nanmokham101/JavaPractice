package com.mk.javase.exceptionhandling;

public class ChainedException {
    static void method(){
        NullPointerException ne = new NullPointerException("Exception top layer");
        ne.initCause(new ArithmeticException("AE occur"));
        throw ne;
    }

    public static void main(String[] args) {
        try{
            method();
        }catch (NullPointerException ne){
            System.out.println("Caught : "+ ne.getMessage());
            System.out.println("Get Cause : "+ ne.getMessage()); // Cause by ArithmeticException / related Exceptions
        }
    }
}
