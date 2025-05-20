package com.mk.javase.lambdaexpression;
interface Predicate{ // boolean return is call predicate
    boolean test(int n);
}
interface Predicate2<T extends Number>{ // Byte, Short, Integer, Long, Double. Float
    boolean test(T n);
}
public class LambdaExpressionDemo { // short hand function if want to use many time use method reference ::
    static boolean not(Predicate fun, int number){ // Lambda as parameter
        return !fun.test(number); // ! e
    }

    public static void main(String[] args) {
        Predicate fun = n -> n%2 == 0; // type inference n is int in fun
     //   System.out.println("Is Even : "+ fun.test(4));

        Predicate2<Integer> fun2 = n -> n%2 ==0;
      //  System.out.println("Is Even Generic: "+ fun2.test(8));

        Predicate2<Double> fun3 = n -> n%2 ==0;
      //  System.out.println("Is Even Generic: "+ fun3.test(8.0));

        System.out.println("Is Odd : "+ not(fun, 3)); // pass even expression as a parameter
        System.out.println("Is Positive : "+ not(n -> n > 0, 5));// expression is true but not -> false

        System.out.println("Is Positive : "+ not(n -> n > 0, -1));
    }
}
