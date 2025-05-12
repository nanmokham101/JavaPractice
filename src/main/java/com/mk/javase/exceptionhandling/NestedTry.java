package com.mk.javase.exceptionhandling;

public class NestedTry {
    public static void main(String[] args) {
        try {
            int result = 2 / 2;
            System.out.println(result);
            try{
                String str = null;
                System.out.println(str.toUpperCase());
            }catch (ArithmeticException a){
                System.out.println("Inner e found : "+ a.getMessage()); // java.lang.NullPointerException: Cannot invoke "String.toUpperCase()" because "str" is null
                // compiler weak point
            }
            System.out.println("end of inner try");
        }catch (Exception ae){ // should catch specific exception in inner try eg. staff should fix the issue
            System.out.println("Outer Exception Ae found : "+ ae.getMessage());
        }
    }
}
