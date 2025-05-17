package com.mk.javase.multithreadprogramming.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/*
    Fork -> parallel later Computer multi CPU , single thread no efficient , ue multi more efficient-> do execution and mix it
    in for loop -> use single loop instead of it use thread 10
    Join - > use thread partition and sum all of thread result
    same with Divide and Conquer
    RecursiveAction -> do like recursive -> all array's square root
    original size = 1000
    fork
        0 -500                  501 -999
        < THRESHOLD                < THRESHOLD
        0 - 250     251 - 495 // divide
    If want return use RecursiveTask
 */
class SquareTransform extends RecursiveAction{ // like recursive but compute concurrent / in multi core compute parallel
    final int THRESHOLD = 100;
    double data[];
    int start, end; // compute

    public SquareTransform(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
        System.out.println("Start : "+ start + " End : "+end);
    }

    @Override
    protected void compute() {
        if( (end - start) < THRESHOLD){ // if less than THRESHOLD do myself
            System.out.println("In myself Start : "+ start + " End : "+end);
            for(int i = start; i < end; i++){
                data[i] = Math.sqrt(data[i]);
            }
        }else{ // fork
            int middle = (start + end)/2;
            invokeAll(new SquareTransform(data, start, middle),
                      new SquareTransform(data,middle, end)); // like void , recursive action no return value
        }
    }
}
public class ForkJoinDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        double[] data = new double[20000];
        for(int i = 0; i < data.length; i++){
            data[i] = i;
        }
        SquareTransform squareTransform = new SquareTransform(data, 0, data.length);
        forkJoinPool.invoke(squareTransform);
        System.out.println("Fork Done.....");
        for(int i = 0; i < 10; i++){
            System.out.println(data[i]);
        }
    }
}
