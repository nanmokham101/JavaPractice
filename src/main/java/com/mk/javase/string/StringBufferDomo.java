package com.mk.javase.string;
/*
    StringBuffer -> thread safe, Synchronized, All thread can't compute on one item
    StringBulider -> not thread safe, not Synchronized, All thread can compute on one item / faster than StringBuffer/ if use one thread use String Builder
 */
public class StringBufferDomo {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("Hello");
        System.out.println("length : "+ buffer.length());
        System.out.println("capacity : "+ buffer.capacity()); // capacity is automatically extend

        buffer.setLength(4); // get length 0 to 3 , Buffer is Mutable can change,  -> want to changes, modify
        System.out.println("setLength : "+ buffer.toString());

        // append() -> like String concat but the original string is changes
        buffer.insert(3,"World");
        System.out.println("insert : "+ buffer.toString()); //HelWorld

        buffer.reverse();
        System.out.println("Reverse : "+ buffer.toString());
    }
}
