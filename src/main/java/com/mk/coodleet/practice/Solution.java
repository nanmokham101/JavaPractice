package com.mk.coodleet.practice;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        java.util.HashMap<Integer, Integer> numMap = new java.util.HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two numbers add up to the target");
    }

    public static void main(String[] args) {
        int [] result = twoSum(new int[]{2,4,3},6);
        for(int a: result){
            System.out.println(a);
        }
    }
}
