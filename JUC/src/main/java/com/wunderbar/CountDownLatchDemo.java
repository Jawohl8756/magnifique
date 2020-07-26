package com.wunderbar;

import java.util.concurrent.CountDownLatch;

/**
 * @author Rommel
 * @date 2020/3/2 14:22
 * @description CountDownLatch 计数器
 *
 * 秦灭6国       6国线程，计数减少归零
 * 一统华夏      最后四海归一，终成大统
 *
 * 功能+性能
 * 先完成，后完美
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        //closeDoor();//6人下课，班长关门
        //System.out.println();
        //System.out.println();
        //System.out.println();


        //1.初始化一个计数器对象，并指定数量
        CountDownLatch countDownLatch = new CountDownLatch(6);

        //6个线程。6个国家，逐一被灭
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 灭亡....");
                //2.做计数减少处理
                countDownLatch.countDown();//
            }, CountryEmum.ForEach_CountryEnum(i).getRetMsg()).start();
        }
        //主线程等到前面的6个子线程执行完毕，才最后执行
        countDownLatch.await();
        //亲王扫六合
        System.out.println(Thread.currentThread().getName() + "\t 6国被灭，秦一统华夏....");

        //枚举可以认为是不用连接的小型数据库db
        System.out.println();
        System.out.println(CountryEmum.SIX);//表
        System.out.println(CountryEmum.SIX.getRetCode());//行
        System.out.println(CountryEmum.SIX.getRetMsg());//列
    }


    //模拟场景一：6人出教室，班长最后锁门走。
    private static void closeDoor() throws InterruptedException {
        //1.初始化一个计数器对象，并指定数量
        CountDownLatch countDownLatch = new CountDownLatch(6);

        //6个线程。6个同学，上完晚自习，走人
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完了自习，离开了教室");
                //2.做计数减少处理
                countDownLatch.countDown();//
            }, String.valueOf(i)).start();
        }
        //主线程等到前面的6个子线程执行完毕，才最后执行
        countDownLatch.await();
        //持有钥匙的主线程班长走人
        System.out.println(Thread.currentThread().getName() + "\t 认为室内没人了，班长关门走人");
    }
}
