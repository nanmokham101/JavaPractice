package com.mk.javase.enumeration;

enum Size{
    Small(1), Medium(2), Large(3);
    private int value;
    Size(int value){
        this.value = value;
    }
    int getValue(){
        return this.value;
    }
}
public class EnumConstructor {
    public static void main(String[] args) {
        Size large = Size.Large;
        Size medium = Size.Medium;
        if(large.getValue() > medium.getValue()){
            System.out.println("large > medium");
        }
        System.out.println("Medium Position : "+ Size.Medium.ordinal());
        System.out.println("Medium Compare to Small : "+ Size.Medium.compareTo(Size.Small)); // compare with ordinal
    }
}
