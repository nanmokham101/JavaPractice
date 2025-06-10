package com.mk.javase.design.creational.factory;
/*
    1. Factory Method -> create object like factory , in jdbc use use Connection behind create MySQL, Oracle connection
        if we pass mySQL connection the factory will return MySQLConnection, program to interface not implementation, OCP

        disadvantage -> mush hierarchy and class
 */
interface Logger{
    void log(String text);
}
class XMLLogger implements Logger{

    @Override
    public void log(String text) {
        System.out.println("XMLLog : "+ text);
    }
}
class ConsoleLogger implements Logger{

    @Override
    public void log(String text) {
        System.out.println("ConsoleLog : "+ text);
    }
}

abstract class LoggerFactory{
    abstract Logger getLogger();
}
class XMLLoggerFactory extends LoggerFactory{

    @Override
    Logger getLogger() {
        return new XMLLogger();
    }
}
class ConsoleLoggerFactory extends LoggerFactory{

    @Override
    Logger getLogger() {
        return new ConsoleLogger();
    }
}
public class FactoryDemo {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new ConsoleLoggerFactory();
        loggerFactory.getLogger().log("This is Console");

        loggerFactory = new XMLLoggerFactory();
        loggerFactory.getLogger().log("This is XML");
    }
}
