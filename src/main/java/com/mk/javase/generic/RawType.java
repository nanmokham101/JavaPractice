package com.mk.javase.generic;

import java.util.ArrayList;

/*
  In Generic behind the sence lowest level -> Object -> Type Eraser
*/
public class RawType {
    public static void main(String[] args) {
        ArrayList<String> strArr = new ArrayList<>();
        strArr.add("Hello");
        strArr.add("World");

        // Can add any type become raw type -> not type safety -> pass type information
        // before jdk 5 we do like this, if delete this in jdk 5+ will become not give backward compatibility
        ArrayList list = new ArrayList();
        list.add("Hi");
        list.add(2.0);

        //list.get(1).doubleValue(); can't get double value because it is Object
    }
}
