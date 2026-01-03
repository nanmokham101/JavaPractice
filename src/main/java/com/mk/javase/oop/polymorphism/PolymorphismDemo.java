package com.mk.javase.oop.polymorphism;
/*
    Polymorphism also call Dynamic Method Dispatch
    Add Base Class
    Extendable, Reliable(safe), less touch less bug/ Don't modify old code because it use by other
    How to Polymorphism :
    -Inheritance
            @Override -> Compiler check it is override or not
            super type reference = sub type object
                super type.method()

    PaymentGateway -> Violate OCP using simple method
    if(card == 'cb'){
        cbGateway();
    }
    if(card == 'aya'){
        ayaGateway();
    }
 */
class Human{
    void work(){
        System.out.println("Human work");
    }
}
class Teacher1 extends Human{// Inheritance
    @Override
    void work(){
        System.out.println("Teacher work");
    }
}
class Doctor1 extends Human{
    @Override
    void work(){
        System.out.println("Doctor work");
    }
}
// Add Engineer OCP support
class Engineer extends Human{
    @Override
    void work(){
        System.out.println("Engineer work");
    }
}

class Waiter extends Human{
    @Override
    void work(){
        System.out.println("Waiter work");
    }
}
public class PolymorphismDemo {
   static void everyoneWork(Human[] humans){
       /*
       Human[] -> we can store in Human[] such as -> Doctor1, Engineer, Teacher1
        */
       for (Human human : humans){
           human.work(); // Working depend on the Object in human instance in Runtime
       }
   }
    public static void main(String[] args) {
        Human[] humans = new Human[]{
                new Teacher1(),
                new Doctor1(),
                new Engineer(), // add Engineer Object only
                new Waiter()
        };
        everyoneWork(humans);
    }
}
