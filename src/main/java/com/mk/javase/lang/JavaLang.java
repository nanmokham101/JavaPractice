package com.mk.javase.lang;
/*
    if JVM run java.lang is up , no need to import -> called default package, Runtime, Exception.. present
    NaN -> not a number
 */
public class JavaLang {
    public static void main(String[] args) {
        String intStr = "128";
        int num = Integer.parseInt(intStr);
        num++;
        System.out.println("Num : "+ num);
    }
}
