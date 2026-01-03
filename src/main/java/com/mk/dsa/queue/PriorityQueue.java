package com.mk.dsa.queue;
/*
        Priority Queue = insert sorting
    [10,20] -> like InsertionSort
    5
    rare 2
    [10,20,5]
    [10,5,20]
    [5,10,20]
    15
    rare 3
    [5,10,20,15]
    [5,10,15,20]

    ----
    [2]
    5
    rare 1
    [2,5]
    [5,2]
    4
    rare 2
    [5,2,4]
    [5,4,2]
    while(item[rare] > item[rare-1]{
        5 > 2
        exchange
    }
 */
public class PriorityQueue extends CircularQueue{
    public PriorityQueue(int maxSize) {
        super(maxSize);
    }
    @Override
    public void enqueue(int item) {
        System.out.println("item -> "+ item);
        if (!this.isFull()) {
           super.enqueue(item);
            System.out.println("Queue before sort-> "+this );
           if(this.noOfItem > 1){
               int index = this.rare;
               while (index >=1 && (this.items[index] > this.items[index-1])){
                   int temp = this.items[index-1];
                   this.items[index-1] = this.items[index];
                   this.items[index] = temp;
                   index--;
               }
           }
        }
        System.out.println("Queue -> "+this );
    }
}
