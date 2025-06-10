package com.mk.javase.design.creational.prototype;
/*
    4. Prototype -> not use new keyword , copy from object to create, want to use properties not object like game character so clone
                  clone the object's properties
 */
interface Prototype extends Cloneable{
    Prototype reproduce();
}
public class PrototypeDemo {
    public static void main(String[] args) {
        HeavyObject compObj = new HeavyObject();
        HeavyObject another = compObj.reproduce();

        System.out.println(compObj);
        System.out.println(another);

    }
}
