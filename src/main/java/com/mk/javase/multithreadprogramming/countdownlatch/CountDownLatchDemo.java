package com.mk.javase.multithreadprogramming.countdownlatch;

import java.util.concurrent.CountDownLatch;

/*
    Have event
    3 thread produce / 3 step
    step has 3 thread
        producer thread
    process
        consumer thread
    -> All 3 event done acquire() / lock()
    decrease from last 3,2,1,0 -> open lock open
    await() -> 0 ma yout ma chin win ma ya / await 0 -> open
 */
class Producer extends Thread{
    CountDownLatch latch;
    Producer(CountDownLatch latch){
        this.latch = latch;
    }
    public void run(){
//        for(int i = 0; i < 5; i++){
//            System.out.println("I "+i);
//            this.latch.countDown();
//        }
        try{
            Thread.sleep(1000);
            System.out.println("Producer Task done");
            this.latch.countDown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread{
    CountDownLatch latch;
    Consumer(CountDownLatch latch){
        this.latch = latch;
    }
    public void run(){
        try{
            this.latch.await();
            System.out.println("Consumer Task done");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch cl = new CountDownLatch(3);
        System.out.println("Start");
        Producer thread1 = new Producer(cl);
        Producer thread2 = new Producer(cl);
        Producer thread3 = new Producer(cl);

        Consumer cThread = new Consumer(cl);
        cThread.start();
        thread1.start();
        thread2.start();
        thread3.start();

//        try {
//            cl.await();
//            System.out.println("Done");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
