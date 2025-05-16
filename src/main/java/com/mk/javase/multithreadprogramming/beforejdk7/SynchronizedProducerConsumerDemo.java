package com.mk.javase.multithreadprogramming.beforejdk7;

/*
    Need thread communication
 */
class Q1 { // to store data
    int n;
    boolean valueSet = false;
    synchronized int get() { // if call get() valueSet must have value -> valueSet = true , Put value first
        while(!valueSet){ // valueSet = false -> !false = true => precess in while til valueSet false
            try {
                wait(); // request to run
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        } // if while loop end valueSet is true -> !true = false so end while condition
        valueSet = false;
        /*
            why valueSet = false;
            consumer - get
                valueSer = false
                    wait(); sleep
            producer - put
                notify(); to awake the sleep thread so set valueSet = false
                we give data to consumer so no value in valueSet
         */
        notify();
        System.out.println("Consumer Get : " + this.n);
        return this.n;
    }

    synchronized void put(int n) {
        while(valueSet){ // if valueSet is true need to wait sleep
            try {
                wait(); // request to run
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        this.n = n; // valueSet = false -> assign this,n = n;
        valueSet = true; // Have valueSet if true wait(); valueSet is ture ready to Consumer get
        System.out.println("Producer Put : " + this.n);
        notify();
    }
}

class Producer1 extends Thread {
    Q1 q1;

    Producer1(Q1 q1) {
        this.q1 = q1;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            this.q1.put(i);
        }
    }
}

class Consumer1 extends Thread {
    Q1 q1;

    Consumer1(Q1 q1) {
        this.q1 = q1;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            q1.get();
        }
    }
}

public class SynchronizedProducerConsumerDemo {
    public static void main(String[] args) {
        Q1 queue = new Q1();
        Producer1 producer1 = new Producer1(queue);
        Consumer1 consumer1 = new Consumer1(queue);

        producer1.start();
        consumer1.start();
        try {
            producer1.join();
            consumer1.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    /*
        Output:
        Producer Put : 0
        Consumer Get : 0
        Producer Put : 1
        Consumer Get : 1
        Producer Put : 2
        Consumer Get : 2
     */
}
/*
    Deadlock
    we have
    Pencil, Paper

    task
        paint -> need both pencil & paper
            use paint thread
                get pencil hold, lock
        write -> need both pencil & paper
            use write thread
                get paper, lock // so deadlock occur
        synchronized() -> thread -1 lock -> block

        Java Thread Lifecycle
        New -> Runnable(start if it's turn) -> Running(currently run not complete) -> Block State(maybe go this state because I/O read slow) need to give other thread that need to run on CPU
        -> Runnable -> Running -> Dead
        I/O -> network, database, file except CPU all contain in I/O
        In Producer Consumer we use synchronized() -> allow 1 thread per 1 time -> want to allow 1 time per 3 thread so can't use/ use semaphore
 */
