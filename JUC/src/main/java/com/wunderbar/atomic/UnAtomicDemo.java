package com.wunderbar.atomic;

import sun.font.TextRecord;

/**
 * @author Rommel
 * @date 2021/2/21 14:43
 * @description 多线程累加计算变量，线程不安全
 */
public class UnAtomicDemo {

    public static int count = 0;

    public static synchronized void unAtomicAdd(int nThread) {
        for (int i = 0; i <= nThread; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    count++;
                }
            }).start();
        }

        System.out.println(nThread + "个线程类加后的结果值为:" + count);
    }

    public static void main(String[] args) {
        unAtomicAdd(100);


    }
}
