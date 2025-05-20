package com.mk.javase.enumeration;
/*
    naming constant / category value
    Class Type -> go with Object
 */
enum Gender{
    MALE, FEMALE, OTHER;
}
enum Color{
    RED, GREEN, BLUE;
}
public class WhyEnum {
    public static void main(String[] args) {
        /*
        int gender = 0;
        gender = 1;
        System.out.println("Gender "+ gender);
         */
        Gender male = Gender.MALE;
        Gender female = Gender.FEMALE;
        System.out.println("Gender : "+ male);

        Color[] colors = Color.values();
        for (Color color : colors) {
            System.out.println("Color : "+ color);
        }
        Color redColor = Color.valueOf("RED"); // String to Enum value // usage in DB only has String need to change enum
        System.out.println("red Color == Color.RED :" + redColor.equals(Color.RED));
    }
}
