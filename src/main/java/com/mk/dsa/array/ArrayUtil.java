package com.mk.dsa.array;

import java.util.Random;

public class ArrayUtil {
    Random random = new Random();
    public int[] getRandomArray(int n, int range){
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(range);
        }
        return arr;
    }
    public void printArray(String message, int[] arr){
        System.out.print(message);
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
    }
    /*
        [1,2,7,8,9,11]
        loop is 0 -> 4 because if reach 4 index next to pick 4(i) and the last index 5(i+1)
    */
    public boolean isArraySorted(int[] arr) {
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
