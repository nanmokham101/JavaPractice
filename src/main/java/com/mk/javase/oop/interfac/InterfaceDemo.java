package com.mk.javase.oop.interfac;
/*
    Interface general - > use AC remote not implementation
    Like USB other implementation(keyboard, mouse) must have the USB function, can make many change and respect interface , Compatibility, less modification , if
    Java reference this concept
    Interface not mush changes -> mush changes in implementation
    Program to interface not implementation / use via interface / human.work(); no need to known what the reference is.
    Different Taxonomy and Hierarchy use Interface
    Eg, Birth, Aeroplane - > fly()
    penguin
    Different Taxonomy -> No Polymorphism : because of super typing -> sub typing / use Polymorphism via Interface
    Pros: Interface generally has empty implementation(no data, contain method) so strong Encapsulation

    Abstract Vs Interface

    Inheritance,
    enforce ,same Taxonomy, same Hierarchy     -> different Taxonomy (same behavior, difference implementation)
    Data can access                            -> strong Encapsulation
    Single Inheritance                         -> Multi Implementation

    Partial Implementation
    Class that implements the Interface must override the method in that interface
    if don't want to override need to declare that method to abstract class
 */
interface Flyable{
    void fly();
    void doSomething();
    String COLOR = "red"; // if declare variable in Interface, it is constant
}
interface Machine{
    void start();
    void stop();
}
class Birth implements Flyable{
    @Override
    public void fly() {
        System.out.println("Birth Fly");
    }

    @Override
    public void doSomething() {

    }
}
class Aeroplane implements Flyable{
    @Override
    public void fly() {
        System.out.println("Aeroplane Fly");
    }

    @Override
    public void doSomething() {

    }
}
abstract class testAbstract implements Flyable{

}
public class InterfaceDemo{
    public static void main(String[] args) {
        Flyable birthFly = new Birth(); // Polymorphism here
        birthFly.fly();

        Flyable aeroplaneFly = new Aeroplane();
        aeroplaneFly.fly();

        Machine droneStart = new Drone();
        droneStart.start();

        Flyable droneFly = new Drone();
        droneFly.fly();
    }
}

class Drone implements Flyable, Machine{
    @Override
    public void fly() {
        System.out.println("Drone Fly");
    }
    @Override
    public void doSomething() {
        System.out.println("Drone do something");
    }

    @Override
    public void start() {
        System.out.println("Drone start");
    }

    @Override
    public void stop() {
        System.out.println("Drone stop");
    }
}
