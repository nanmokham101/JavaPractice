package com.mk.test.test;

import java.util.Arrays;

public class test {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int L = 0, R = n - 1;
        int index = n - 1;

        while (L <= R) {
            int left = nums[L] * nums[L];
            int right = nums[R] * nums[R];

            if (left > right) {
                result[index] = left;
                L++;
            } else {
                result[index] = right;
                R--;
            }
            index--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = sortedSquares(new int[]{-7,-3,2,3,11});
        System.out.println(Arrays.toString(arr));
    }
}
