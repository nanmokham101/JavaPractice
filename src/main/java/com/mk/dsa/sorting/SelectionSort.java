package com.mk.dsa.sorting;
/*
    gp forward
    [2,7,9,11,8,1]
    [1,7,9,11,8,2] -> 0
    [1,2,9,11,8,7] -> 1
    [1,2,7,11,8,9] -> 2
    [1,2,7,8,11,9] -> 3
    [1,2,7,8,9,11] -> 4
    outer loop = go / sort 0-3 because last is already sorted
    inner loop = to find smallest item
    to swap

    Pseudo code
    for(int i = 0; i < length - 1; i++){ // length: 5 -1 = 4 / i < 4 / 0 to 3 / last is auto sorted
        //minIndex = 0 = i
        for(int j = i + 1; j < length; j++){ // when i is 0 already pick one item to compare and find min item/ j must be 0+1 = go next index/ find min
            //find min arr[minIndex] > j;
            minIndex = j
        }
        //swap
        i = 0; minIndex = 0;
        int temp = arr[i] // 0
        arr[i] = arr[minIndex] // 0 = 5 / arr[0] = 5
        arr[minIndex] = temp // arr[minIndex] = 0
        [2,7,9,11,8,1] -> [1,7,9,11,8,2] swap index 0 and 5

        i = 1; minIndex = 1;
        int temp = arr[i] // 1
        arr[i] = arr[minIndex] // 1 = 5 / arr[1] = 5
        arr[minIndex] = temp // arr[minIndex] = 1
        [1,7,9,11,8,2] -> [1,2,9,11,8,7] swap index 1 and 5

        Time Complexity(CPU) -> O(n^2) // not so good be aware
        Swap take more time

        Space Complexity(RAM) -> O(1) // Allocate one array and use many time
    }
*/
public class SelectionSort implements Sortable{
    @Override
    public void sort(int[] arr) {
        for(int i = 0; i < arr.length -1; i++){ // n
            int minIndex = i;
            for(int j = i+1; j< arr.length; j++){ // almost n so n^2
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

}
