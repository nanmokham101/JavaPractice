package com.mk.dsa.sorting;
/*
    [9,3,0,6,1,5]
    i = 0
    inner loop -> j = 0; to j < length - i -1
    j < 6 - 0 -1= j < 5
    [3,9,0,6,1,5] -> 0

    i = 1
    j < 6 - 1 -1= j < 4
    [3,0,9,6,1,5] -> 1

    i = 2
    j < 6 - 2 -1 = j < 3
    [3,0,6,9,1,5] -> 2
    [3,0,6,1,9,5] -> 3
    [3,0,6,1,5,9] -> 4

    [0,3,6,1,5,9] -> 0
    [0,3,6,1,5,9] -> 1
    [0,3,1,6,5,9] -> 2
    [0,3,1,5,6,9] -> 3

    [0,3,1,5,6,9] -> 0
    [0,1,3,5,6,9] -> 1
    max -> last
    outer loop -> i = 0; to i < length -1 = i < 5
    inner loop -> j = 0; to i < length - i

    Time Complexity(CPU) -> O(n^2) // not so good be aware
    Swap take more time -> Swap in inner loop

    Space Complexity(RAM) -> O(1) // Allocate one array and use many time
*/

import com.mk.dsa.array.ArrayUtil;

public class BubbleSort implements Sortable{
    ArrayUtil arrayUtil = new ArrayUtil();
    @Override
    public void sort(int[] arr) {
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){ // check j+1 so j < arr.length-i-1 // remain last 2 index because need to swap and already sorted
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                arrayUtil.printArray("Inner loop j arr sorted ", arr);
            }
            System.out.println("");
            arrayUtil.printArray("Outer loop i arr sorted ", arr);
        }
    }
}
