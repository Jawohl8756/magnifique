package com.wunderbar.volatiles;/**
 *
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author katze
 * @date 2020/7/27 15:56
 * @description volatile是轻量级关键字，保证内存可见性的，适用于happens-before原则
 * volatile关键字特点：
 * 1.不保证原子性    不适合 i++原子操作场合
 * 2.保证内存可见性  适合happens-before原则
 * 3.禁止指令重排
 */
public class DontVolatile implements Runnable {
    volatile int a ;
    AtomicInteger realA =new AtomicInteger();


    public static void main(String[] args) throws InterruptedException {
        Runnable r =  new DontVolatile();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("volatile不保证原子性，获取的a变量值:"+((DontVolatile) r).a);
        System.out.println("AtomicInteger原子类保证原子性，获取的变量值:"+((DontVolatile) r).realA.get());
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            a++;
            realA.incrementAndGet();
        }
    }
}
