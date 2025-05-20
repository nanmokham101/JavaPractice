package com.mk.javase.io;

import java.util.Scanner;
/*
    Console read -> not to read with BufferReader -> out of date / read with scanner
 */
public class ReadConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number : ");
        int num = scanner.nextInt();
        System.out.println("Your number is : "+ num);

        System.out.println("Enter String : ");
        String str = scanner.next();
        System.out.println("Your string is : "+ str);
    }
}
