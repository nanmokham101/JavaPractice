package com.mk.javase.lambdaexpression;

import java.util.function.*;
import java.util.function.Predicate;

/*
    we need to create expression for FP -> there are built in predefined functional interface use if fix with need
    1. UnaryOperator -> accept one parameter return that one value with same type -> apply()
    2. BinaryOperator - > * - * / -> accept two parameter return that one value same type - > apply()
    3. Consumer -> no return accept one parameter, want to pass two or more parameter need to create Object and pass with Obj parameter -> accept()
    4. Supplier -> no parameter input but return value , give -> get()
    5. Function -> pass two parameters<T,R> input -> output <R> -> input String output Integer - > apply()
    6. Predicate -> accept any one type -> return boolean ->

    use
 */
public class PredefinedFunctionalInterface {
    public static void main(String[] args) {
        UnaryOperator<String> fun = str -> str.toLowerCase();
        System.out.println(fun.apply("HELLO"));
        fun = str -> str.toUpperCase();
        System.out.println(fun.apply("hi"));

        BinaryOperator<Integer> binaryFun = (a,b) -> a + b;
        System.out.println(binaryFun.apply(3,4));

        Consumer<String> consumerFun = str -> {
            System.out.println(str); // no return type
        };
        consumerFun.accept("Momo");

        Supplier<String> supplierFun = () -> {
            return "Hello"; // need return type
        };
        System.out.println(supplierFun.get());

        Function<String, Integer> function = str -> str.length();
        System.out.println(function.apply("momo"));

        Predicate<Integer> predicate = n -> n%2 == 0;
        System.out.println(predicate.test(2));
    }
}
