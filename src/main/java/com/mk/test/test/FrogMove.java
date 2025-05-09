package com.mk.test.test;

public class FrogMove {
    public static int solution(int[] blocks) {
        int N = blocks.length;

        if (N == 2) return 2;

        int[] leftReach = new int[N];
        int[] rightReach = new int[N];

        // Calculate left reach for each block
        leftReach[0] = 1;
        for (int i = 1; i < N; i++) {
            if (blocks[i] >= blocks[i - 1]) {
                leftReach[i] = leftReach[i - 1] + 1;
            } else {
                leftReach[i] = 1;
            }
        }

        // Calculate right reach for each block
        rightReach[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (blocks[i] >= blocks[i + 1]) {
                rightReach[i] = rightReach[i + 1] + 1;
            } else {
                rightReach[i] = 1;
            }
        }

        // Find the maximum possible distance
        int maxDistance = 0;
        for (int i = 0; i < N; i++) {
            maxDistance = Math.max(maxDistance, leftReach[i] + rightReach[i] - 1);
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 6, 8, 5}));
       // System.out.println(solution(new int[]{1, 5, 5, 2, 6}));
      //  System.out.println(solution(new int[]{1,1}));
    }
}
