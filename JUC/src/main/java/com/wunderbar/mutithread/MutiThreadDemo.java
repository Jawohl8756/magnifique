package com.wunderbar.mutithread;/**
 *
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author katze
 * @date 2020/7/27 10:51
 * @description 创建多个线程的方式
 */
public class MutiThreadDemo {
    public static void main(String[] args) {
        Thread t1 =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程名称:"+Thread.currentThread().getName());
            }
        });
        t1.start();

        Thread t2 =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程名称:"+Thread.currentThread().getName());
            }
        });
        t2.start();

        ExecutorService service=Executors.newFixedThreadPool(2);
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("i am here ,catch me .");
            }
        });
    }

}
