package com.mk.javase.annotation;

public class AnotherTestCase {
    @AnnotationDemo
    void TestCase1(){
        System.out.println("Compute AnotherTestCase1");
    }
    @AnnotationDemo
    void TestCase2(){
        System.out.println("Compute AnotherTestCase2");
    }
    void normalMethod(){
        System.out.println("Compute normal method");
    }
}
