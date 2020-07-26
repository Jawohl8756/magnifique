package com.wunderbar.oom;

/**
 * @author Rommel
 * @date 2020/3/22 16:05
 * @description 线程的start 和 run方法的区别
 */
public class T {

    public static void main(String[] args) {
        Thread t1 =new Thread();
        t1.start();
        t1.start();
    }
}
