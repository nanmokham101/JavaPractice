package com.mk.javase.multithreadprogramming.beforejdk7;
/*
    InterThread Communication
    Image download -> process
    thread 1 - download
    thread 2 - process
    after thread 1 complete thread 2 will execute -> if download thread not complete the process thread can't process = Producer1 Consumer1 Problem
    Producer1 done his job and notify to Consumer1 => InterThread Communication
    wait() = sleep , need something wait it -> need to process wait until download complete -> if thread 1 wait() to process image after download done other thread block
    notifyAll() -> notify all thread to run
 */
class Data {
    int value;

    Data(int value) {
        this.value = value;
    }
}

class IncThread extends Thread {
    Data data;

    IncThread(Data data) {
        this.data = data;
    }

    public void run() {

        for (int i = 0; i < 100000; i++) { // thread can run parallel
            synchronized (this.data) { // thread 1 use data and lock other must wait -> thread 1 complete other take
                // Thread can't run parallel in data.value++; bottleneck, wait sequential, request
                // after thread 1 finish, OS will decide to execute who get the request
                this.data.value++;
            }
        }
    }
    /*
        3 thread
        .value++; value = value+1;
        in JVM
        - ILOAD value
        - INCREASE
        - ISTORE value
        data(0)
        in thread 1 -> value + 1 = 1 on stack -> store value = 1
        in thread 2 -> value + 1 = 1 on stack -> also store value = 1 override the thread 1 value (because run parallel) hit parallel
        actual value = 1; // call Synchronization Problem / In JVM run 3 line in parallel /not complete run 1 line(Atomic Operation)/ eg. People use toilet together so occur synchronization problem
        Can prevent this problem -> lock / eg. when someone use toilet must lock the door - >synchronized(this.data) -> thread 1 use data and lock other must wait
     */
}

public class SynchronizationProblem {
    public static void main(String[] args) {
        Data data = new Data(0);
        IncThread thread1 = new IncThread(data);
        IncThread thread2 = new IncThread(data);
        IncThread thread3 = new IncThread(data);

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
        System.out.println("Data : " + data.value); // without synchronized Data : 110908 different value when run/ use synchronized the actual data will print
    }
}
