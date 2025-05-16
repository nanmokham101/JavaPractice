package com.mk.javase.multithreadprogramming.thread;

/*
    MultiThreading
    Long Long age Computer OS - > Single Programming
    What's single programming -> Can run one program per one time
    Program -> not run (Chrome)
    Process -> running program in Computer -> run almost parallel (Concurrent)
    Core 8 = CPU 8 -> Program 1,2,3 -> One CPU =run P1 one time, run P2 one time, run P3 one time (eg. bicycling). The whole CPU run Parallel(eg, People competition in bicycle race many people participate they do parallel)
    Process = The whole Application
    -> Use CPU to read file : CPU very fast to read but file very slow not to use CPU -> CPU wait -> Blocking / IO slow so related to read file
    Switch process = scheduling -> which process to run after this process done
    MultiProgramming -> resource efficiently(htae yout)
    Concurrency:
    -Process, Memory -> file read CPU kick to IO, CPU process another = Process switching (turn for CPU)
    A -> B (A switch to B) CPU mark A original state to run next time if need to run A in CPU again = call Context Switching (Costly, use many time)
    Thread = Under Process / competition part ( Java have built in Thread)
    In Context switching have Thread(run parallel) Eg. In Microsoft Word typing text(1 thread), color (1 thread) , font(1 thread)

    We have 4 staff : 8 task
    non-thread model (staff 1 need to do all of 8 tasks take long time)
    thread model (each staff do specific task fast) depend in CPU, CPU have 8 Core = can run Parallel at least 8 Thread
    if OS have only 1 CPU -> want run Thread 100 can't do concurrency but IO adv

    Single Core -> Concurrent Thread (Adv)
        - but also have adv 1 CPU have multi Thread
        - Multi Thread:
            Thread 1 -> read file // not need CPU
                     -> turn next process // no need to run CPU
        - CUP bound/IO bound -> powerful : CPU bound = Arithmetic operation(+,-,*,/), image processing, cryptography, IO bound Read/ Write
    Multi core -> Parallel Thread

    Java Thread depend on OS thread 1 thread take memory 1MB many thread=many memory usage
    Thread has priority (Preempted model = one task finish other task run) if set Thread Priority need to give memory for that
    if give high priority more opportunity (VVIP, VIP)
 */
class MyThread extends Thread {
    String name;

    MyThread(String name) {
        this.name = name;
    }

    public void run() { // this run() not run start to end // run switching // Thread One stop and mark the end of State Thread One and continue next turn
        // Can't control order/ OS manage Thread / JVM Java not have Thread, depend on OS thread
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + this.name + " -> " + i);
           // System.out.println("Thread " + Thread.currentThread().getName() + " -> " + i);

        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Thread name : "+ Thread.currentThread().getName()); // JVM start Thread name : main
        try{
            Thread.sleep(5000); //sleep 5s after print will print next
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        MyThread thread1 = new MyThread("One");
        MyThread thread2 = new MyThread(("Two"));
        MyThread thread3 = new MyThread(("Three"));

        //   thread1.start(Thread.MIN_PRIORITY); // just suggestion JVM give priority but upto OS (eg. Lady say please take care of my child first but upto doctor)
        //    thread3.start(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start(); // not order = concurrent = interleave = switching = time slicing run (1s time Thread One)
        System.out.println("Thread One isAlive : "+ thread1.isAlive());
        System.out.println("Thread Two isAlive : "+ thread2.isAlive());
        System.out.println("Thread Two isAlive : "+ thread2.isAlive());
        try{
            thread1.join(); // wait Thread1 util execution end
            thread2.join(); // wait Thread2 util execution end
            thread3.join(); // wait Thread3 util execution end
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Thread One isAlive : "+ thread1.isAlive());
        System.out.println("Thread Two isAlive : "+ thread2.isAlive());
        System.out.println("Thread Two isAlive : "+ thread2.isAlive());
        System.out.println("Hello"); // want to print Hello after all of 3 Thread done use join();
        /*
        Thread Three -> 97
        Thread Three -> 98
        Thread Three -> 99
        Thread Two -> 0
        Thread One -> 0
        Thread Two -> 1
        Thread Two -> 2
        //In this main() we have 3 Thread
         */
    }
}
