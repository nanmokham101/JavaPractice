package com.mk.javase.lambdaexpression;
/*
    Classname :: new // pass Obj and create Object
 */
class Human{
    String name;
    Human(String name){
        this.name = name;
    }
}
class Teacher extends Human{
    Teacher(String name){
        super(name);
        System.out.println("Teacher "+ name);
    }
}
class Doctor extends Human{
    Doctor(String name){
        super(name);
        System.out.println("Doctor "+ name);
    }
}
interface Factory{ // in design pattern factory create Obj
    Human create(String name); // set return type so can pass what Obj
}
public class GenericConstructorReference {
    public static void main(String[] args) {
        Factory factory = Teacher::new;
        factory.create("Momo");

        factory = Doctor::new;
        factory.create("Toto");
    }
}
