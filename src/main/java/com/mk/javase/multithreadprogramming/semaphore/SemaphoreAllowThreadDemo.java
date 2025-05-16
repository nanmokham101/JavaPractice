package com.mk.javase.multithreadprogramming.semaphore;

import java.util.concurrent.Semaphore;

class MyThread extends Thread{
    String name;
    Semaphore semaphore;
    MyThread(String name, Semaphore semaphore){
        super();
        this.name = name;
        this.semaphore = semaphore;
    }
    public void run(){
        for (int i = 0; i < 10; i++){
            try {
                semaphore.acquire();
                System.out.println("Thread "+ this.name +" - > " + i);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            try {
                Thread.sleep(1000);
                semaphore.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
public class SemaphoreAllowThreadDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2); // allow 2 thread to enter
        MyThread thread1 = new MyThread("One",sem);
        MyThread thread2 = new MyThread("Two", sem);
        MyThread thread3 = new MyThread("Three", sem);
        MyThread thread4 = new MyThread("Four", sem);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread2.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
        without join()
Thread Two - > 0
Thread One - > 0
Thread One - > 1
Thread Two - > 1
Thread One - > 2
Thread Two - > 2
Thread One - > 3
Thread Two - > 3
Thread One - > 4
Thread Two - > 4
Thread One - > 5
Thread Two - > 5
Thread One - > 6
Thread Two - > 6
Thread One - > 7
Thread Two - > 7
Thread One - > 8
Thread Two - > 8
Thread One - > 9
Thread Two - > 9
Thread Three - > 0
Thread Four - > 0
Thread Three - > 1
Thread Four - > 1
Thread Three - > 2
Thread Four - > 2
Thread Three - > 3
Thread Four - > 3
Thread Three - > 4
Thread Four - > 4
Thread Three - > 5
Thread Four - > 5
Thread Three - > 6
Thread Four - > 6
Thread Three - > 7
Thread Four - > 7
Thread Three - > 8
Thread Four - > 8
Thread Three - > 9
Thread Four - > 9


with join();
Thread Two - > 0
Thread One - > 0
Thread Two - > 1
Thread One - > 1
Thread Two - > 2
Thread One - > 2
Thread Two - > 3
Thread One - > 3
Thread Two - > 4
Thread One - > 4
Thread Two - > 5
Thread One - > 5
Thread Two - > 6
Thread One - > 6
Thread Two - > 7
Thread One - > 7
Thread Two - > 8
Thread One - > 8
Thread Two - > 9
Thread One - > 9
Thread Three - > 0
Thread Four - > 0
Thread Three - > 1
Thread Four - > 1
Thread Three - > 2
Thread Four - > 2
Thread Three - > 3
Thread Four - > 3
Thread Three - > 4
Thread Four - > 4
Thread Three - > 5
Thread Four - > 5
Thread Three - > 6
Thread Four - > 6
Thread Three - > 7
Thread Four - > 7
Thread Three - > 8
Thread Four - > 8
Thread Three - > 9
Thread Four - > 9
         */
    }
}