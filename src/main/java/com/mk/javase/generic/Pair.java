package com.mk.javase.generic;
// Tuple
// Multi type version in Static PL

public class Pair<T, U> {
    T first;
    U second;
    public Pair(T first, U second){
        this.first = first;
        this.second = second;
    }
    public T getFirst(){
        return this.first;
    }
    public U getSecond(){
        return this.second;
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Momo", 27);
        System.out.println("First : "+ pair.getFirst() + "/ Second : "+ pair.getSecond());
    }
}
