package com.mk.test.test.dsa.queue;

import com.mk.dsa.queue.CircularQueue;
import com.mk.dsa.queue.IQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircularQueueTest{
    IQueue queue = new CircularQueue(5);
    @Test
    public void testDequeueUnderFlow(){
        for(int i = 0; i < 5; i++){
            queue.enqueue(i);
        }
        assertEquals(5, queue.getSize());
        assertEquals(false, queue.isEmpty());

        for(int i = 0; i < 5; i++){
            assertEquals(i, queue.dequeue());
        }

        queue.enqueue(10);
        assertEquals(1, queue.getSize());
        assertEquals(10, queue.dequeue());
        assertEquals(true, queue.isEmpty());
    }
}
