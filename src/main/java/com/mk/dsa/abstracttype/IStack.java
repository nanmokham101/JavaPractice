package com.mk.dsa.abstracttype;

public interface IStack {
    void push(int element);
    int pop();
    int peek();
    int getSize();
    boolean isFull();
    boolean isEmpty();
}
