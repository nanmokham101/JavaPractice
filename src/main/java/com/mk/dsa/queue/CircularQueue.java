package com.mk.dsa.queue;
/*
    size = 5
    rare - 4
    rare ++ = 5 not want 5 want 0
    rare %= size => 5%5 = 0

    Dequeue = can insert both front and rare

 */
public class CircularQueue extends QueueDemo{
    public CircularQueue(int maxSize) {
        super(maxSize);
    }

    @Override
    public void enqueue(int item) { // insert from rare +1, element - push, item++
        if (!this.isFull()) {
            this.rare = (this.rare+1) % this.maxSize;
            this.items[this.rare] = item;
            this.noOfItem++;
        }
    }

    @Override
    public int dequeue() {
        System.out.println("call dequeue");
        if (!this.isEmpty()) {
            this.front = (this.front+1) % this.maxSize;
            this.noOfItem--;
            return this.items[this.front];
        }else{
            throw new RuntimeException("Stack underflow error");
        }
    }
}
