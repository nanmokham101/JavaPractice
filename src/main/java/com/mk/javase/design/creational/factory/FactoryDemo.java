package com.mk.javase.design.creational.factory;
/*
    1. Factory Method -> create object like factory , in jdbc use use Connection behind create MySQL, Oracle connection
        if we pass mySQL connection the factory will return MySQLConnection, program to interface not implementation, OCP

        disadvantage -> mush hierarchy and class
 */
interface Payment{
    void pay(String text);
}
class ABankPayment implements Payment{

    @Override
    public void pay(String text) {
        System.out.println("Pay with : "+ text);
    }
}
class BBankPayment implements Payment{

    @Override
    public void pay(String text) {
        System.out.println("Pay with : "+ text);
    }
}

abstract class PaymentFactory{
    abstract Payment getPayment();
}
class ABankPaymentFactory extends PaymentFactory{

    @Override
    Payment getPayment() {
        return new ABankPayment();
    }
}
class BBankPaymentFactory extends PaymentFactory{

    @Override
    Payment getPayment() {
        return new BBankPayment();
    }
}
public class FactoryDemo {
    public static void main(String[] args) {
        PaymentFactory paymentFactory = new ABankPaymentFactory();
        paymentFactory.getPayment().pay("ABank");

        paymentFactory = new BBankPaymentFactory();
        paymentFactory.getPayment().pay("BBank");
    }
}

