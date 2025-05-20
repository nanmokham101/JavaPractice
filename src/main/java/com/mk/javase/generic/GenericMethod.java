package com.mk.javase.generic;
/*
    <T extends Comparable<T>, V extends T> -> allow type that implements Comparable
 */
class Util{
    static <T extends Comparable<T>> boolean isIn(T item, T[] arr){ // no need V extends T
        for(int i = 0; i < arr.length; i++){
            if(item.equals(arr[i])){ //if(arr[i].compareTo(item) == 0){
                return true;
            }
        }
        return false;
    }
}
public class GenericMethod {
    public static void main(String[] args) {
        Integer[] intArr = {1,4,7,8,9};
        Integer item = 3;
        System.out.println("Is In : "+ Util.isIn(item, intArr));

        // We can't find in with String and Integer
        String[] strArr = {"Hi","Hello"};
        System.out.println("String is iin : "+ Util.isIn("Hi",strArr));
    }
}
