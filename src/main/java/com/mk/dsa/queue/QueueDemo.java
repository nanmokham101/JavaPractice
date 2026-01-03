package com.mk.dsa.queue;

import java.util.Arrays;

/*
    FIFO
    front rear, enqueue -> put, tail ++
    front insert, rare - pop
     dequeue -> pop, head++
     if tail== head can't dequeue
    facing right side
    put -> 1 ->
    circular -> why circular because if full problem
 */
public class QueueDemo implements IQueue {
    protected int maxSize;
    protected int[] items;
    protected int front;
    protected int rare;
    protected int noOfItem;

    public QueueDemo(int maxSize) {
        this.maxSize = maxSize;
        this.items = new int[maxSize];
        this.front = -1;
        this.rare = -1;
    }

    @Override
    public void enqueue(int item) { // insert from rare +1, element - push, item++
        if (this.rare < this.maxSize - 1) {
            this.items[++this.rare] = item;
            this.noOfItem++;
        }
    }

    @Override
    public int dequeue() {
        if (this.front < this.maxSize - 1) {
            this.noOfItem--;
            return this.items[++this.front];
        }else{
            throw new RuntimeException("Stack underflow error");
        }
    }

    @Override
    public int peek() {
        if (!this.isEmpty()) {
            return this.items[this.front + 1];
        } else {
            throw new RuntimeException("Queue is underflow");
        }
    }

    @Override
    public boolean isFull() {
        return this.noOfItem == this.maxSize;
    }

    @Override
    public boolean isEmpty() {
        return noOfItem == 0;
    }

    @Override
    public int getSize() {
        return this.noOfItem;
    }

    @Override
    public String toString() {
        String data = "";
        for(int i: items){
            data+= i + " ,";
        }
        return data;
    }
}
