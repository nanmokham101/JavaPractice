package com.mk.dsa.queue;

public interface IQueue {
    void enqueue(int item); // insert
    int dequeue();
    int peek();
    boolean isFull();
    boolean isEmpty();
    int getSize();
}
