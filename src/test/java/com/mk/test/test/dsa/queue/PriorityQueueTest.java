package com.mk.test.test.dsa.queue;

import com.mk.dsa.queue.IQueue;
import com.mk.dsa.queue.PriorityQueue;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityQueueTest {
    IQueue queue = new PriorityQueue(5);
    Random random = new Random();
    @Test
    public void testBaseCase(){
        queue.enqueue(10);
        assertEquals(false, queue.isEmpty());
        int element = queue.dequeue();
        assertEquals(10,element);
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testPriorityQueue(){
        for(int i = 0; i < 5; i++){
            int ran = random.nextInt(10);
            System.out.println("Push "+ ran);
            queue.enqueue(ran);
        }
//        queue.enqueue(5);
//        queue.enqueue(10);
//        queue.enqueue(3);
//        queue.enqueue(8);
//        queue.enqueue(25);
        int first = queue.dequeue();
        for(int i = 1; i < 5; i++){
            int second = queue.dequeue();
            System.out.println("First "+ first + "      Second "+ second);
           assertEquals(true, first >= second);
           first = second;
        }
    }
}
