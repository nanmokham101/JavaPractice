package com.mk.javase.oop.interfac;
/*
    -Interface has multiple extends
    -Contract public (method, parameter, return type)- If contract present it's OK
    -In Class if multi extend how can call parent

    Interface not to have many method -> class that implements that interface, need to implement all method without being necessary
 */
interface First{
    void doFirst();
}
interface Second extends First{
    void doSecond();
}
interface Another extends First, Second{
    void doAnother();
}

class TestMultiInterClass implements Another{

    @Override
    public void doFirst() {
        System.out.println("Do first");
    }

    @Override
    public void doSecond() {
        System.out.println("Do Second");
    }

    @Override
    public void doAnother() {
        System.out.println("So Another");
    }
}
public class MultiExtendInterfaceDomo {
    public static void main(String[] args) {
        Another another = new TestMultiInterClass();
        another.doFirst();
        another.doSecond();
        another.doAnother();
    }
}
