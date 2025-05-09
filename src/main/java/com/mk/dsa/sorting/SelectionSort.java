package com.mk.dsa.sorting;
/*
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
        for(int j = i + 1; j < length; j++){ // when i is 0 already sorted/ j must be 0+1 = go next index

        }
    }
*/
public class SelectionSort {
}
