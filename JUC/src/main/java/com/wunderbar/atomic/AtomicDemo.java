package com.wunderbar.atomic;

import com.wunderbar.oom.T;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Rommel
 * @date 2021/2/21 15:20
 * @description 多线程原子操作
 */
public class AtomicDemo {

    public static int count = 0;
    public static int synchronizedCount = 0;
    public static AtomicInteger atomicCount = new AtomicInteger();

    /**
     * synchronized关键字修饰的方法
     * */
    public static synchronized void synchronizedCount() {
        synchronizedCount++;
    }

    public static void main(String[] args) {
        //准备100 个线程
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {

            //每个线程对变量加10次 ，想得到100 *10的结果
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    count++;//普通累加
                    synchronizedCount();//同步关键字累加
                    atomicCount.getAndIncrement();//原子类累加

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });

            threads[i].start();
            System.out.println(i+":starts now");
        }

        // 等待所有线程执行完毕继续
        for (int i = 0; i < threads.length; i++) {
            try {
                System.out.println("join" + i);
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("count:" + count);
        System.out.println("synchronizedCount:" + synchronizedCount);
        System.out.println("atomicCount:" + atomicCount.get());

    }
}
