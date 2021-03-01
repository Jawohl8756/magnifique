package com.wunderbar.dp;

/**
 * @author Rommel
 * @date 2020/10/18 14:01
 * @description 使用递归 ，dp ,斐波那契求解
 */
public class ClimbStairs {


    public static void main(String[] args) {
        int steps = climbStairs(3);
        System.out.println("steps=" + steps);

    }

    /**
     * @param n
     * @return
     */
    public static int climbStairs(int n) {


        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;

        for (int i = 2; i < n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }

        return mem[n - 1];
    }
}



