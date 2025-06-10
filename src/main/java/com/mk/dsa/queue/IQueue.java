package com.mk.dsa.queue;

public interface IQueue {
    void enqueue(int item);
    int dequeue();
    int peek();
    boolean isFull();
    boolean isEmpty();
    int getSize();
}
