package com.mk.javase.streamapi;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

/*
    want to operate parallel in multi core processor
 */
public class ParallelStream {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 100000000; i++){
            list.add(random.nextInt(1000));
        }
        /*
            [1000] -> in 1 Core compute 1 time
         */
        double start = System.currentTimeMillis();
        Stream<Integer> intStream = list
                .stream()
                .filter(n -> n%2 ==0);
        double end = System.currentTimeMillis();
        double time = end-start;
        System.out.println("Start time in Stream : "+ start);
        System.out.println("End time in Stream : "+ end);
        System.out.println("Time : "+ time);

        /*
            Parallel Stream -> thread automatically handle for multi-threading
            Stream copy original value so increase the storage space
            [1000] -> all core compute eg. 8 core -> execute 8 time like
            100 - 100 - 100 split 10 time and collaborate the result
            depend on your core
         */
        start = System.currentTimeMillis();
        Stream<Integer> parallelStream = list
                .parallelStream()
                .filter(n -> n%2 ==0);
        end = System.currentTimeMillis();
        time = end-start;
        System.out.println("Start time in Parallel Stream : "+ start);
        System.out.println("End time in Parallel Stream : "+ end);
        System.out.println("Time : "+ time);

    }
}
