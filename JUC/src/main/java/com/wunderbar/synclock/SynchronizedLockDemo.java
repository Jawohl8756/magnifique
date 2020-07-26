package com.wunderbar.synclock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Rommel
 * @date 2020/3/6 15:40
 * @description synchronized 和 lock有什么区别？
 */
public class SynchronizedLockDemo {

    public static void main(String[] args) {
        synchronized(new Object()){
            System.out.println("yyyyyyyyyyyyyyyy");
        }



        new ReentrantLock();


    }
}
