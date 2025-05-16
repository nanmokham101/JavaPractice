package com.mk.javase.multithreadprogramming.thread;

/*
    If we have Class that already extend other Class so can't extend Thread Class (Java not allow multi extend)
    use Runnable Interface
 */
class MyThread1 implements Runnable {
    Thread thread;

    public MyThread1(String name) {
        this.thread = new Thread(this, name); // this ->  the object whose run method is invoked when this thread is started. If null, this thread's run method is invoked.
    }

    void start() { // Thread in Runnable doesn't have start() need to write it
        this.thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + Thread.currentThread().getName() + " -> " + i);
        }
    }
}

public class ThreadWithRunnable {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1("One");
        MyThread1 thread2 = new MyThread1(("Two"));
        MyThread1 thread3 = new MyThread1(("Three")); // if want to run Thread while create Object should start() thread in Constructor

        thread1.start(); // Thread run
        thread2.start();
        thread3.start();
        System.out.println("Hello"); // want to print Hello after all of 3 Thread done use join(); can't call join() because this is Runnable need to use Thread Class
        // But main thread run itself in concurrent so Hello print fast
        //
    }
}
