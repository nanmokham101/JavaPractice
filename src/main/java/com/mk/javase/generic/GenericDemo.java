package com.mk.javase.generic;
/*
    Type as a parameter(String, Integer, Human) no need to create each Stack with for each parameter
    jdk 5+ / only modify Compiler code not modify JVM code
    Type safe only in compile time , runtime type eraser, behind the sense save with Object type
 */
class GStack<T>{
    T[] items;
    int top = -1;
    GStack(){
        this.items = (T[]) new Object[10]; // behind the sense compute with Object type
    }
    void push(T value){
        this.items[++top] = value;
    }
    T pop(){
        return this.items[top--];
    }
}
public class GenericDemo {
    public static void main(String[] args) {
        GStack<Integer> iStack = new GStack<>();
        iStack.push(3);
       // Integer num = iStack.pop(); // can assign both primitive and Wrapper
        int num = iStack.pop();

        GStack<String> sStack = new GStack<>();
        sStack.push("Hello");
     //   String str = sStack.pop();

        System.out.println(sStack.pop().getClass());
    }
}
