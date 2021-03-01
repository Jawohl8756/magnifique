package com.wunderbar.jdk;

import org.omg.CORBA.OBJECT_NOT_EXIST;

import java.util.concurrent.TimeUnit;

/**
 * @author Rommel
 * @date 2020/12/5 20:32
 * @description LockSupport
 */
public class ObjectWaitNotifyDemo {


    static Object objectLock = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            /**
             * 先让线程A停止3s,线程B先执行唤醒操作了，出异常
             * 一定要一个线程先wait，另一个线程再notify
             *
             * 按顺序，否则，线程先唤醒完成，另一个线程还傻傻的等待唤醒呢，程序跑死
             */

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            /**
             * 两个线程的wait和notify操作一定要在同一个代码块内
             * 必须要用synchronized关键字限定，否则报错
             *
             * */
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + ":coming in ");
                try {
                    objectLock.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":对象被唤醒");
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName()+":对象被通知");
            }
        }, "B").start();


    }
}
