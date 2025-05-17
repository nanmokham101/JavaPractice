package com.mk.javase.multithreadprogramming.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    Executor collaborate with Thread Pool how to use thread that created from thead pool
    Virtual Thread ->
    No thread in JVM, 1 thread= 1 native thread(OS thread) need memory almost 1MB
    thread 10 -> 10 MB create, destroy - > not OK
    Thread
        active -> current running
        idle -> ready to run (arr ny tae thread)  -> need to run thread call idle thread
    Better to control and manage thread in thread pool
    not parallel but concurrent
 */
class MyThread extends Thread{
    String name;
    CountDownLatch cl;
    MyThread(CountDownLatch cl, String name){
        this.cl = cl;
        this.name = name;
    }
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("Thread : "+ this.name + " i -> "+ i);
            this.cl.countDown();
        }
    }
}
public class ExecutorDemo {
    public static void main(String[] args) {
        CountDownLatch cd1 = new CountDownLatch(5);
        CountDownLatch cd2 = new CountDownLatch(5);
        CountDownLatch cd3 = new CountDownLatch(5);
        CountDownLatch cd4 = new CountDownLatch(5);

        ExecutorService es = Executors.newFixedThreadPool(2); // set fixed thread size
        es.execute(new MyThread(cd1, "One"));
        es.execute(new MyThread(cd2, "Two"));
        es.execute(new MyThread(cd3, "Three"));
        es.execute(new MyThread(cd4, "Four"));

        try {
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        es.shutdown();
    }
}
