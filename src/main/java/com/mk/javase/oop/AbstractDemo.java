package com.mk.javase.oop;

/*
    In Polymorphism because of Inheritance we need Human Object.
    None concrete class is call Abstract class
    Eg. we don't have Human Object is not present not need but want to use in specialized/child so we use Abstract
    The class with Abstract method is called Abstract Class. Can't instantiate Object for Human.
    The class that extend Abstract Class need to override the parent abstract method.
    Or need to make abstract class in Child's method. Enforce to override method that extend Parent Abstract Class.
    Abstract do inheritance so need the same Biological (Taxonomy)

    Why Abstract Class
    -Contract ( if parent sell bread and enforce child to sell bread can modify better version
    -No need Base Object eg Human is not Object

 */
abstract class Human{
    abstract void work();
    final void finalMethod(){       // Disallow to override final class also
        System.out.println("Final Method");
    }
    protected String name; // Child class and same package can access
}
class Teacher1 extends Human {
    @Override
    void work(){
        System.out.println("Teacher work");
    }
//    @Override
//    void finalMethod(){
//
//    }
}
class Doctor1 extends Human {
    @Override
    void work(){
        System.out.println("Doctor work");
    }
}
// Add Engineer OCP support
class Engineer extends Human {
    @Override
    void work(){
        System.out.println("Engineer work");
    }
}
public class AbstractDemo {
        public static void main(String[] args) {
            Human human = new Teacher1();
            human.work();
        }
    }

