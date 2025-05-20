package com.mk.javase.lambdaexpression;
/*
    before jdk 8 -> not present lambda -> so want to Functional Programming
    1. can assign function as a variable
    2. pass function as a parameter
    3. return function from function
    call first class function. want to FP so need first class function add Lambda jdk8+ to support FP
    add(int a, int b)
    div(int a, int b) in JS can pass these two function

    Because of giving Lambda in jdk8 so modify JVM byte code in jdk8
    Lambda -> short term of methods / anonymous function / contain parenthesis, parameter, method body, return type
    Method reference -> ClassName :: method / :: is method reference operator / can use with Generic
    short usage -> Lambda
    usage everytime, repeat -> Method reference
 */
interface Fun{
    // not more than one method, same signature which method to add in First Class Function
    int method(int a,  int b); // there is only one method in interface is called FP

    // can add interface in this Fun, the FP not working , if want to do create First Class Function for it
    //void getSomething();

}
interface SideEffect{
    void sideEffectMethod();
}
public class WhyLambda {
    // want to do operation depend on condition
    static int add(int a, int b){
        return a + b;
    }
    static int div(int a, int b){
        return a * b;
    }
    static void doSomething(){
        System.out.println("Do Something");
    }
    // instance method
    void instanceMethod(){
        System.out.println("Instance Method");
    }
    public static void main(String[] args) {
        // want to pass add, div method as a parameter so need one variable to store these two methods
       // var fun = add; -> limitation because Java is type programming
        Fun fun = WhyLambda :: add; // for static go with Class Name
        System.out.println("Add : "+ fun.method(1,2));

        // can assign other method to fun -> because same signature (same return type, parameters) / different signature can't
        fun = WhyLambda :: div;
        System.out.println("Div : "+ fun.method(2,2));

      //  fun = WhyLambda :: doSomething; not compile because different signature

        SideEffect sideEffect = WhyLambda :: doSomething;
        sideEffect.sideEffectMethod();

        //Instance method go with obj
        var instance = new WhyLambda();
        sideEffect = instance::instanceMethod;
        sideEffect.sideEffectMethod();

        fun = (int a, int b) -> a *b; // same signature with fun
        System.out.println("Lambda Division : "+ fun.method(2,4));
        fun = (a, b) -> a + b; // type inference
        //multi line function need return statement -> use single line lambda
        fun = (int a, int b) ->{
            return a + b;
        }; // expression -> return value is call expression,
    }
}
