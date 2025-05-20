package com.mk.javase.wrapper;

import java.util.ArrayList;

/*
    Store primitive type to Object/ Reference type is call Wrapper
    Every primitive type have their Wrapper Class
    Use Primitive to Object
    int -> Integer
    byte -> Byte
    double -> Double
    chat -> Character
    float -> Float
    Why wrapper - > In stack push pop we can only create int stack but want to create String stack - > use Generic
    Object -> descending from Object can put / There is not central datatype for primitive and Object
    class Stack{ // int stack
        int[] items;
    }
    class SStack{ // String stack so need to write many Stack class so we can use Generic
        Object[] items;
    }
    class Stack<Integer>{ store , put by Object /descending from Object can put / in primitive can not put (htae)
        // we can use simple primitive because can't assign to Object -> want to store primitive to Object call Wrapper
    }
 */
public class WhyWrapperDemo {
    public static void main(String[] args) {
        Integer i = 0; // primitive - wrapper - Object
        i++;
        System.out.println("i instanceof Object : "+ i instanceof Object);

        ArrayList<Integer> list = new ArrayList<>(); // we can't add primitive ArrayList<int> because this is Generic
        list.add(1);
        list.add(2);

        Character character =  Character.valueOf('A'); // Object type Char
        Double dou = Double.valueOf(100);
    }
}
