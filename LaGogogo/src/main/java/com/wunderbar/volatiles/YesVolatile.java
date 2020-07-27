package com.wunderbar.volatiles;/**
 *
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author katze
 * @date 2020/7/27 16:21
 * @description volatile的正常使用场景
 */
public class YesVolatile implements Runnable {

    volatile boolean done = false;
    AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new YesVolatile();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(((YesVolatile) r).done);
        System.out.println(((YesVolatile) r).realA.get());
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            setDone();
            realA.incrementAndGet();
        }
    }

    private void setDone() {
        done = true;
    }
}
