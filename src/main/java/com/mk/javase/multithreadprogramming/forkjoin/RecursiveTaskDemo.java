package com.mk.javase.multithreadprogramming.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/*
    return value when fork
    return in compute, recursive divide and sum the result

    Synchronous
        line 1 -> totally done and run line 2 / getValue();
        line 2 -> getValue(); is totally get answer
    Asynchronous
        line 1 -> parallel concurrent run not done in line 1
        line 2 -> also run in parallel
    ForkJoin -> invoke() wait all compute done and compute next run -> so Synchronous
 */
class Sum extends RecursiveTask<Double>{
    final int THRESHOLD = 100;
    double data[];
    int start, end; // compute

    public Sum(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
        System.out.println("Start : "+ start + " End : "+end);
    }
    @Override
    protected Double compute() {
        double sum = 0;
        if( (end - start) < THRESHOLD){ // if less than THRESHOLD do myself
            System.out.println("In myself Start : "+ start + " End : "+end);
            for(int i = start; i < end; i++){
                sum += data[i];
            }
        }else{ // fork
            int middle = (start + end)/2;
            Sum taskA = new Sum(data, start, middle);
            Sum taskB = new Sum(data, middle+1, end);
            taskA.fork(); // compute parallel
            taskB.fork();
            sum = taskA.join() + taskB.join();
        }
        return sum;
    }
}
public class RecursiveTaskDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        double[] data = new double[11];
        for(int i = 0; i < data.length; i++){
            data[i] = i;
        }
        Sum sum = new Sum(data,0, data.length);
     //   double result = forkJoinPool.invoke(sum); //Synchronous
     //   System.out.println("Result : "+ result);
        forkJoinPool.execute(sum); //Asynchronous // usage send email 1000 compute send email function in each thread
        System.out.println("Asynchronous Done");
    }
}
