package com.wunderbar.timecomplex;/**
 *
 */

/**
 * @author katze
 * @date 2020/8/5 14:56
 * @description 大O表示法 时间复杂度
 */
public class TimeComplexDemo {

    public static void main(String[] args) {
        System.out.println("cal(10) = " + cal(10));
    }

    /**
     * 计算：1+..+..+10
     * 25 26 行分别消耗1个unit_time
     * 27 28 行分别消耗n个unit_time
     *
     * 总的时间耗时：
     * (2n+2)*unit_time
     *
     * */
    public static int cal(int n) {
        int sum = 0;
        int i = 1;
        for (; i <= n; ++i) {
            sum = sum + i;
        }
        return sum;
    }

    /**
     * 整段代码总的执行时间 T(n) = (2n2+2n+3)*unit_time
     * 40 41 42 :3*unit_time
     * 43 44 2n*unit_time
     * 45 46 n^2*unit_time
     * */
    public static int cal1(int n) {
        int sum = 0;
        int i = 1;
        int j = 1;
        for (; i <= n; ++i) {
            j = 1;
            for (; j <= n; ++j) {
                sum = sum + i * j;
            }
        }
        return sum;
    }

    /**
     * T(n)=O(logn)
     * */
    public static int cal2(int n) {
        int i = 1;
        while (i <= n) {
            i = i * 2;
        }
        return 1;
    }

    /**
     * T(n)=O(log3 n)
     * */
    public static int cal3(int n) {
        int i = 1;
        while (i <= n) {
            i = i * 3;
        }
        return i;
    }


}
