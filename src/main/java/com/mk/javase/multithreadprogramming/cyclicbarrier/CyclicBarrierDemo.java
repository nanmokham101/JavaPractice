package com.mk.javase.multithreadprogramming.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
    like Gate
    step 1 -> run concurrently (step = thread)
    step 2 -> run concurrently
        step 3 -> after step 1,2 done want to run step 3 - requirement
    real world eg, friend go trip if all of friends are ready and go
 */
class MyThread extends Thread{
    CyclicBarrier cb;
    String name;
    MyThread(CyclicBarrier cb , String name){
        this.cb = cb;
        this.name = name;
    }
    public void run(){

        try {
            Thread.sleep((long) (1000 * Math.random()));
            System.out.println("Thread "+ this.name +" arrived.");
            this.cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
class BarAction implements Runnable{
    @Override
    public void run() {
        System.out.println("All arrived! Time to go...");
    }
}
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
        MyThread thread1 = new MyThread(cb, "One");
        MyThread thread2 = new MyThread(cb, "One");
        MyThread thread3 = new MyThread(cb, "One");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
