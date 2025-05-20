package com.mk.javase.lambdaexpression;
/*
    Lambda expressions are not allow to modify variable inside and outside. but allow to use in expression
 */
interface Func{
    void fun();
}
public class VariableCapture {
    public static void main(String[] args) {
        int a = 10;
        Func func = () -> {
            System.out.println("A is "+ a);
          //  a++; // here can't modify inside
        };
       //  a++; // here can't modify outside
        func.fun();
    }
}
