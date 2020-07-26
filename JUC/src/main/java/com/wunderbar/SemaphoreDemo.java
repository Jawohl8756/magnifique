package com.wunderbar;

import com.wunderbar.cas.TimeUtil;

import java.util.concurrent.Semaphore;

/**
 * @author Rommel
 * @date 2020/3/2 18:14
 * @description 信号量
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//3个停车位

        for (int i = 1; i <= 6; i++) {//6部汽车
            new Thread(() -> {

                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到了车位.....");
                    TimeUtil.SECONDS.sleep(3);//停在车位3秒钟
                    System.out.println(Thread.currentThread().getName() + "\t停车3秒后离开车位.....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            }, String.valueOf(i)).start();

        }

    }
}
