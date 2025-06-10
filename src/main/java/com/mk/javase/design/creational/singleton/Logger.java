package com.mk.javase.design.creational.singleton;
/*
    5. Singleton -> Single instant, Only one, another way Global variable, can create Constructor by new, keep constructor private.
                    if want get instance -> set static (only one copy instant from class)
 */
public class Logger {
    private static Logger instance;
    private Logger(){

    }

    public static Logger getInstance() {
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }
    public void log(String text){
        System.out.println("Log : "+ text);
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println(logger1 == logger2);
    }
}
