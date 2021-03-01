package com.wunderbar.jdk;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Rommel
 * @date 2020/12/5 20:59
 * @description Condition#await
 * #signal
 * 阻塞和唤醒线程
 */
public class ConditionAwaitSignalDemo {

    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {

        new Thread(() -> {

            /**
             *2.如果condition的await和notify方法不是严格按照顺序的，
             * 先notify再wait，那么程序跑死，死锁。这个线程永远wait了
             *
             * */
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /**
             * 1.如果lock对象不成双成对的lock()/unlock()
             * 程序就会报异常：
             * IllegalMonitorStateException
             * */
            lock.lock();//不能不成对关闭，不能注释掉
            try {

                System.out.println(Thread.currentThread().getName() + ":coming in-------");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

            System.out.println(Thread.currentThread().getName() + ":线程被唤醒。。。。。。。。");

        }, "t1").start();


        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + ":线程被通知");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();

    }
}
