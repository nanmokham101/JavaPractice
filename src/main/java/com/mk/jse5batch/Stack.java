package com.mk.jse5batch;
/*
    Encapsulation : protect internal state, disallow invalid operation
*/
public class Stack {
    private int items[];
    private int top = -1;

    public Stack(int size) {
        this.items = new int[size];
    }

    private void push(int element){
        this.items[++top] = element;
    }

    private int pop(){
        return this.items[top--];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(100);
        System.out.println(stack.pop());
        System.out.println("------------");
        stack.push(10);
        stack.push(50);
        stack.push(200);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
