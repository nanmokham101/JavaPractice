package com.mk.javase;
/*
* 2 3 4 5 6 outerloop
* 2 => 1 to 12 multiplication innerloop
* */
public class MultiplicationLoop {
    public static void main(String[] args) {
        for(int i = 2; i <= 6; i++) {
            for (int j = 1; j <= 12; j++) {
                System.out.println(i + " * " + j + " = " + i * j);
            }
            System.out.println("-------------");
        }
    }
}
