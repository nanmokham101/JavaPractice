package com.mk.test.test.dsa.queue;

import com.mk.dsa.queue.CircularQueue;
import com.mk.dsa.queue.IQueue;
import com.mk.dsa.queue.QueueDemo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestQueue {
    IQueue queue = new QueueDemo(5);
   // IQueue queue = new CircularQueue(5);

    @Test
    public void testArrayQueue(){

        int originalSize = queue.getSize();
        queue.enqueue(10);
        assertEquals(false, queue.isEmpty());
        assertEquals(10, queue.peek());
        int element = queue.dequeue();
        assertEquals(10,element);
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testEnQueueMany(){
      //  int originalSize = queue.getSize();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        assertEquals(false, queue.isEmpty());
        assertEquals(10,queue.dequeue());
        assertEquals(20,queue.dequeue());
        assertEquals(30,queue.dequeue());
        assertEquals(40,queue.dequeue());
        assertEquals(true, queue.isEmpty());
    }

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

        Assertions.assertThrows(RuntimeException.class, () ->{
            queue.dequeue();
        });
    }

    @Test
    public void testPeek(){
        queue.enqueue(10);
        assertEquals(false, queue.isEmpty());
        assertEquals(10, queue.peek());
        assertEquals(false, queue.isEmpty());
    }
}
