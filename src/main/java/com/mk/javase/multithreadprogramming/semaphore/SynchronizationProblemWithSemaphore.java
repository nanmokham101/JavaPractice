package com.mk.javase.multithreadprogramming.semaphore;

import java.util.concurrent.Semaphore;

/*
    Synchronized allow 1 thread per 1 time
    Semaphore allow multi thread per 1 time
    Thread nature -> producer thread first
     Semaphore
        value = 1
        lock(){
            value --
        }
        lock(){ }// value = 0 so block , get lock() = acquire() / not 0 allow to acquire()
        Eg. have 3 toilets 1 person acquire()
        semaphore(value = 3)
        acquire() -> pass
            value = 2;
        acquire() -> pass
            value = 1;
        acquire() -> pass
            value = 0;
        acquire() -> fail -> block -> wait
        release()
            value ++;
 */
class Data1 {
    int value;

    Data1(int value) {
        this.value = value;
    }
}

class IncThread1 extends Thread {
    Data1 data;
    Semaphore semaphore;

    IncThread1(Data1 data, Semaphore semaphore) {
        this.data = data;
        this.semaphore = semaphore;
    }

    public void run() {

        for (int i = 0; i < 100000; i++) {
            try {
                this.semaphore.acquire();
                this.data.value++;
                this.semaphore.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class SynchronizationProblemWithSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1); // allow 1 thread per 1 time
        Data1 data = new Data1(0);
        IncThread1 thread1 = new IncThread1(data, semaphore);
        IncThread1 thread2 = new IncThread1(data, semaphore);
        IncThread1 thread3 = new IncThread1(data, semaphore);

        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Data : " + data.value);
    }
}

