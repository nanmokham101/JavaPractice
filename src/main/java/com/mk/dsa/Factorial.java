package com.mk.dsa;

public class Factorial {
    private static int factorial(int n){
        if(n == 0 ){
            return 1;
        }
        System.out.println(n);
        return n * factorial(n - 1); // 4 * 3 * 2 * 1
    }

    public static void main(String[] args) {
        int result = factorial(4);
        System.out.println(result);
    }
}
