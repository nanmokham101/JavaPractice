package com.mk.test.test.dsa.abstracttype;

public class GreaterAndNotLessThan {
    static boolean isGreaterThan(int lastChar, int firstChar) {
        return lastChar > firstChar;
    }

    static boolean isLessThan(int lastChar, int firstChar) {
        return lastChar < firstChar;
    }

    public static void main(String[] args) {
//        while(!isLessThan(5,3)){
//            System.out.println("5 is not less than 3");
//        }

        while(isGreaterThan(5,3)){
            System.out.println("5 is greater 3");
        }
    }
}
