package com.mk.javase.multithreadprogramming.callable;

import java.util.concurrent.*;

/*
    Callable -> thread return pyan tor thread -> but return value can't return immediately can return later , can known the return when
    Future -> thread return value
    Time Unit -> Callable limit time to wait answer. return eg. order delivery after 30 mins not arrived do cancel order
    Concurrent Collection -> allow one thread to operation Data structure concurrency control pr lr pee tar built in data structure AtomicInteger is one of them
    lock = synchronized
    ReentrantLock  -> can enter lock the same thread
 */
class Sum implements Callable<Integer> {
    int stop;

    Sum(int stop) {
        this.stop = stop;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < stop; i++) {
            sum += i;
        }
        Thread.sleep(2000);
        System.out.println("Finish Sum");
        return sum;
    }
}

class Factorial implements Callable<Integer> {
    int n;

    Factorial(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println("Finish Factorial");
        return result;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> sum;
        Future<Integer> factorial;
        System.out.println("Starting");
        sum = es.submit(new Sum(5));
        factorial = es.submit(new Factorial(5));

        try {
           // System.out.println("Sum : "+ sum.get());
            System.out.println("Sum : " + sum.get(10, TimeUnit.MILLISECONDS)); // execute but not finish block(not block run-concurrently / wait for other not give the return, answer) here sum factorial finish but sum not finish wait sum to get();
            System.out.println("Factorial : " + factorial.get());
        } catch (TimeoutException e) {
            System.out.println("Timeout : " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        es.shutdown();
        System.out.println("Done..");
        /*
            Output :
            Starting....
            Finish Factorial // finish but not give result
            Finish Sum
            Sum : 10
            Factorial : 120
            Done...

            1000 ms = 1s
            1000 micro s = 1ms
            Starting
            Finish Factorial
            Timeout : null // main thread get exception
            Done..
            Finish Sum // but sum thread do this task still run
         */
    }
}
