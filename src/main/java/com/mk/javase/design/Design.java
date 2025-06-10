package com.mk.javase.design;
/*
    SOLID
    S -> Single Responsibility: one class or one method working, dao work for db, service work for business logic, only one work
        Class should have one and only one reason to change
    O -> Open Close : open for extension close for modification
    L -> Liskov : No need to known the specific instance that from super reference, can pass child reference in parent reference
    D -> Dependency Inversion  : instantiate the instance or object from outside and parse as dependency parameter, don't create itself
    DI -> dependency injection: No need to create instance or object from outside Spring automatically inject the dependency

    There are 3 types of design pattern : Creational, Structural, Behavioural
    Aggregation -> part of relationship, can stand itself -> email - email attachment
    Composition -> part of relationship, can't stand itself -> email attachment - email
    Inheritance -> is a, kind of
    Dependency -> B depend on A
    Association -> It's Ok not even depend on A
    Sequence diagram -> method call order
    Abstract -> highlight the important part, not detail
    Creational : Object creation
        1. Factory Method
        2. Abstract Factory
        3. Builder
        4. Prototype
        5. Singleton

    Structural: Object structure
        1. Adapter
        2. Bridge
        3. Composite
        4. Decorator
        5. Facade
        6. Flyweight
        7. Proxy

3. Composite -> tree structure, recursive shape
    Menu                    Department
        SubMenu                     Employee
            Item1                   SubDepartment
            Item2
4. Decorator-> Original role class, added function
    Pizza - Original
        Chicken - added function (not properties)
        Cheese
        Vegetable
    want pizza with chicken. vegetable
    class Pizza{
    }
    class ChickenPizza extends Pizza{
    }
    class ChickenVegetablePizza extends Pizza{
    }
    class ChickenCheesePizza extends Pizza{
    }
    make many class inheritance -> not want to use inheritance use composition
    requirement -> add additional pattern and feature

.........
    Observer-Observable -> event like chartModel -> pieChart, barChart, graph if chartModel change the associate chart need to change so tightly couple
    requirement want to notify all associate chart use Observer- Observable/ Publisher Subscriber model
    one to many dependency if one change the many need to change
    Event in JS
        dom.addEventListener("click",handler1);
        dom.addEventListener("click",handler2); // so dom is Observer and handler1,2 are Observable

.....
5. Facade -> Client -> api1, api2, api3 for one task working need to call all api, when api1 is change is depend on all
    so replace with simple api client call facade method that call all apis
    Client not direct call all api so call to facade method shield all api with facade method

.....
6. Flyweight -> Cache - thread pool, connection pool. reuse
    Use sharing to support large number of of fine-grained objects efficiently

-----
7. Proxy - Middle real project doesn't have security so add security function in proxy that give additional information
    proxy give the data that the real object that not haves like Wrapper class in java
    decorator vs proxy-> decorator give data that is dynamically change adn proxy give the data that can't change that the real g=project doesn't give
   Behavioural: Runtime behaviour
       1. Chain of Responsibility
       2. Command
       3. Iterator
       4. Mediator
       5. Memento
       6. Observer
       7. State
       8. Strategy
       9. Template Method
       10. Visitor

       ----

       1. Chain of Responsibility -> filter, what to add step by step
       request
            do log // exist with functional layer, can extend more and isolated
                do security
                    controller

      ------
      2. Command -> contain all information to execute, no need to know how and who execute like file copy and save button
      -----
      8. Strategy -> if to polymorphism , parsing  object
      ----
      9. Template Method -> in framework give auth step and we can override business logic
                                auth - step
                                    call business logic
     -----
     7. State -> multi form success, add to cart - payment - payment info - checkout = state machine
     ----
     3. Iterator -> getNext(); loop for tree, graph
     ----
      4. Mediator -> like group chat, user1 send text user2 and user3 must get text, if user4 new add need to send user4 too so coupling direct send
      uniform traversal -> add SMSMediatorImpl middle so user1 send message to SMSMediatorImpl and SMSMediatorImpl will send to all users
      so not direct send to each user

      ----
      5. Memento -> Object store - un store- undo . save like snapshot and store object. save history
      ---
      10. Visitor -> for develop compiler

 */
public class Design {
}
