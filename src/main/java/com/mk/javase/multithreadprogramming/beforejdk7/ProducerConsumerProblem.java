package com.mk.javase.multithreadprogramming.beforejdk7;
/*
    Thread 1 produce done consume thread can execute problem call Producer1 Consumer1 Problem
 */
class Q { // to store data
    int n;
    synchronized int get(){
        System.out.println("Get : "+ this.n);
       return this.n;
    }
    synchronized void put(int n){
        System.out.println("Put : "+ this.n);
        this.n = n;
    }
}
class Producer extends Thread{
    Q1 q1;
    Producer(Q1 q1){
        this.q1 = q1;
    }
    public void run(){
        for (int i = 0; i < 10; i++){
            this.q1.put(i);
        }
    }
}
class Consumer extends Thread{
    Q1 q1;
    Consumer(Q1 q1){
        this.q1 = q1;
    }
    public void run(){
        for (int i = 0; i < 10; i++){
            int value = q1.get();
            System.out.println("Consumer1 Get Value : "+ value);
        }
    }
}
public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Q1 queue = new Q1();
        Producer1 producer1 = new Producer1(queue);
        Consumer1 consumer1 = new Consumer1(queue);

        producer1.start();
        consumer1.start();
        try {
            producer1.join();
            consumer1.join();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    // Output is not correct need thread communication
}
