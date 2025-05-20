package com.mk.javase.annotation;

public class TestCase {
    @AnnotationDemo
    void TestCase1(){
        System.out.println("Compute TestCase1");
    }
    @AnnotationDemo
    void TestCase2(){
        System.out.println("Compute TestCase2");
    }
    void normalMethod(){
        System.out.println("Compute normal method");
    }
}
