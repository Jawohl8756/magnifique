package com.wunderbar;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Rommel
 * @date 2020/3/2 17:59
 * @description 循环屏障
 * CountDownLatch 计数器，做减法 5 4 3 2 1 go
 * CyclicBarrier  栅栏  ，做加法 1 2 3 4 5 到齐了，一起走
 * 集齐7颗龙珠，方可召唤神龙。
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("7颗龙珠已经集齐，召唤神龙吧。。。。");
        });

        for (int i = 1; i <= 7; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println("搜集到了第" + tempInt + "课龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
