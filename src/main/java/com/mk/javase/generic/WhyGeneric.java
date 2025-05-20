package com.mk.javase.generic;

class Stack{
    int[] items;
    int top = -1;

    public Stack() {
        this.items = new int[10];
    }
    void push(int value){
        this.items[++top] = value;
    }
    int pop(){
        return this.items[top--];
    }
}

class GeneralStack{
    Object[] items;
    int top = -1;

    public GeneralStack() {
        this.items = new Object[10];
    }
    void push(Object value){
        this.items[++top] = value;
    }
    Object pop(){
        return this.items[top--];
    }
}
public class WhyGeneric {
    public static void main(String[] args) {
//        Stack stack = new Stack();
//        stack.push(10);
//        System.out.println(stack.pop());

        // Can use all Object type and primitive to wrapper
        GeneralStack generalStack = new GeneralStack();
        generalStack.push("Apple");
        generalStack.push(2);
        Integer num = (Integer) generalStack.pop(); // need to type cast to Integer 1 problem
        // not type safety because of object type / if push Integer want to get Integer but Type eraser
        // Generic -> container type (Stack) always use. specific create by type
        System.out.println(generalStack.pop());
    }
}
