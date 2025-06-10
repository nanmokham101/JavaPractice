package com.mk.javaEE;
/*
    Spring = DI (Dependency Injection)
    Webserver -> can serve static programming, want dynamic -> use CGI (common gate interface like php apache can run the php script in webserver -> fork and execute create new process by interpreter
    have problem client request to php -> apache need to call php code per request -> interpreter container ever run depend on apache one request per php interpreter
    Container -> multiple request this container ever run and serve to server -> not rely on traditional model -> Webserver functionality + JSP servlet
    Bean -> Java class with getter and setter, no argument constructor
    POJO-> Plain Old Java Object - > don't extends or implement from other
    Service ->Spring Bean and when need dependency Spring create
    SOLID
    S -> Single Responsibility Principal, if one class need to compute only Responsibility
        Employee class -> save(), payroll(), report() -> many Responsibility. One class should be have one function but need to do perfect
    O -> OCP Open for extension not for modification
    L -> Liskov Substitution can child object can replace parent reference
    I -> Interface Segregation ->don't create useless interface, not use fat interface use thin interface
    D -> Dependency Inversion-> create outside and parse object that call it

    Bean, Service, Component , Controller create by Spring Lifecycle management when create and when destroy
    class ProductService{
        InventoryService inventoryService; // Spring create InventoryService and inject to ProductService
    }
    Spring Application Context -> the whole Spring Application
    Artifact id -> project name, group id -> package name
    Controller - handle request
 */
class Engine{
    void start(){
        System.out.println("Engine start.");
    }
}
class GasEngine extends Engine{
    void start(){
        System.out.println("Gas Engine start.");
    }
}
class Car{
    Engine engine;
    Car(Engine engine){
        this.engine = engine;
    }
    void start(){
        System.out.println("Car start.");
        this.engine.start();
    }
        }
public class Spring {
    public static void main(String[] args) {
        Engine engine = new GasEngine(); // L // DI here is problem need to create Engine object A->B->C need to create A first then create B and Create C called DI
        Car car = new Car(engine);// D - > Car use Parent reference -> parse with child reference or parent -> But Penguin can't replace to use with parent Bird violate the Liskov
        car.start(); // not touch the car
    }
}
