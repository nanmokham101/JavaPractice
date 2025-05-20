package com.mk.javase.generic;

public class GenericConstructor {
    private double value;
    <T extends Number> GenericConstructor(T value){
        this.value = value.doubleValue();
    }

    void getValue() {
        System.out.println("Value : "+ this.value);
    }

    public static void main(String[] args) {
        GenericConstructor gc = new GenericConstructor(20);
        gc.getValue();

        GenericConstructor gc1 = new GenericConstructor(2.4);
        gc1.getValue();
    }
}
