package com.mk.javase.wrapper;
/*
    Autoboxing -> Box = Wrapper -> primitive to Wrapper
    Unboxing - > primitive -> Wrapper to primitive
    Please use Wrapper when needed int 4MB but wrapper use 8MB
    eg. Integer age; // can be present or not, can set null, so can't use int
 */
public class BoxingUnboxing {
    static Integer method(Integer i){
        return i++;
    }
    public static void main(String[] args) {
        Integer a = 10; // Autoboxing -> Primitive to Wrapper
        int b = a; // Unboxing -> Wrapper to Primitive
        a++; // Wrapper - Primitive++ - Wrapper
        int result = method(100); // method Primitive to Wrapper / Autoboxing Unboxing do comfortable between Primitive and Wrapper by Compiler
        Integer d = a + result;// expression also do Autoboxing Unboxing
    }
}
