package com.mk.javase.multithreadprogramming.phaser;

import java.util.concurrent.Phaser;

/*
    Multi step form
    step 1
        step 2
            step 3 -> run sequentially 1 by 1 1khu pee mha 1khu
    thread 1 -> step 1
    thread 2 -> step 1
    thread 3 -> step 1  all done
    next
    thread 1 -> step 2
    thread 2 -> step 2
    thread 3 -> step 2  all done
    next
    thread 1 -> step 3
    thread 2 -> step 3
    thread 3 -> step 3  all done

    real world -> sport competition swimming, bicycling, racing participate step by step
    register()
    arrive()
    join() -> all threads concurrently run and stop when arrived goal
 */
class MyThread extends Thread{
    Phaser phaser;
    String name;
    MyThread(Phaser phaser, String name){
        this.phaser = phaser;
        this.name = name;
        this.phaser.register();
    }
    public void run(){
        System.out.println("Thread "+ this.name + " arrived Phrase One");
        this.phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread "+ this.name + " arrived Phrase Two");
        this.phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread "+ this.name + " arrived Phrase Three");
        this.phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.phaser.arriveAndDeregister();
    }
}

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // first time 1 and then register() increase step by step
        int currentPhase;
        new MyThread(phaser, "A").start();
        new MyThread(phaser, "B").start();
        new MyThread(phaser, "C").start();

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase "+ currentPhase+" complete");

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase "+ currentPhase+" complete");

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase "+ currentPhase+" complete");
        phaser.arriveAndDeregister();
    }
}
