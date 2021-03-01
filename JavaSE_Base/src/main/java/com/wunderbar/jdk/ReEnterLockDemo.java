package com.wunderbar.jdk;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Rommel
 * @date 2020/12/5 19:35
 * @description 可重入锁
 */
public class ReEnterLockDemo {

    public synchronized void m1() {
        System.out.println("外层===");
        m2();

    }

    private synchronized void m2() {
        System.out.println("中层===");
        m3();
    }

    private synchronized void m3() {
        System.out.println("内层===");
    }


    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        // new ReEnterLockDemo().m1();

        new Thread(() -> {
            lock.lock();
            lock.lock();
            try {
                System.out.println("进入了外层");
                lock.lock();
                try {
                    System.out.println("进入了中层");
                    lock.lock();
                    try {
                        System.out.println("进入了外层");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                lock.unlock();//如果被注掉，没有成对开闭可重入锁。那么其他线程无法获取锁和执行了。。。。死锁。。。。
            }


        }, "t1").start();


        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "：另一个线程开始进入了。。。。。。。。。。。");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();

    }


}
