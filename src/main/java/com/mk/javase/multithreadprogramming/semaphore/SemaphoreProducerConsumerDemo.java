package com.mk.javase.multithreadprogramming.semaphore;

import java.util.concurrent.Semaphore;

class Q { // to store data
    int n;
    boolean valueSet = false;
    Semaphore producerSemaphore = new Semaphore(1); // producer need to run thread first so open to enter value = 1
    Semaphore consumerSemaphore = new Semaphore(0); // consumer no to to get first so ser value = 0 / close after producer done it'll be notify to wake
    int get() {
        try {
            consumerSemaphore.acquire();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Consumer Get : " + this.n);
        producerSemaphore.release();
        return this.n;
    }

    void put(int n) { // need to get semaphore lock
        try {
            producerSemaphore.acquire(); // producerSemaphore is 1 / acquire() -1
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        this.n = n;
        System.out.println("Producer Put : " + this.n);
        consumerSemaphore.release(); // consumerSemaphore is 0 so release +1
    }
}

class Producer extends Thread {
    Q q;

    Producer(Q q) {
        this.q = q;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            this.q.put(i);
        }
    }
}

class Consumer extends Thread {
    Q q;

    Consumer(Q q) {
        this.q = q;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            q.get();
        }
    }
}
public class SemaphoreProducerConsumerDemo {
    public static void main(String[] args) {
        Q queue = new Q();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
