package com.mk.dsa.sorting;
/*
    Sort card // go backward
    concept is index 0 already sorted and index 1 to last not sort
    already sorted is i , swap item is j
    [7,6,3,9,11,10]
    [6,7,3,9,11,10] -> look index 2 and compare from the first index, swap 6 and 3
    [3,6,7,9,11,10]
    [3,6,7,9,10,11]

    i = 1;
    j = i; j = 1;
    while j > 0 && arr[j-1] > arr[j] -> swap j--
    i++

    i = 1;
    j = 1;
    [7,6,3,9,11,10]

    Time Complexity(CPU) -> O(n^2) // not so good be aware
    Swap take less time

    Space Complexity(RAM) -> O(1) // Allocate one array and use many time*/
public class InsertionSort implements Sortable{
    @Override
    public void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){ // [7,6] // swap 6 first so take temp = arr[j]
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
}
