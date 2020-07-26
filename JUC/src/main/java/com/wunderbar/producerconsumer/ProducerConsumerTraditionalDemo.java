package com.wunderbar.producerconsumer;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Rommel
 * @date 2020/3/6 13:26
 * @description 生产消费者模型-传统版
 * <p>
 * 两个线程，分别操作数值变量，一个加1，一个减1，操作5轮
 * <p>
 * 高并发情况下，高内聚，低耦合
 * 上联： 高内聚、低耦合
 * 下联：判断干活 唤醒 通知
 * 横幅：严防多线程状态下的虚假唤醒
 * <p>
 * 1、线程  操作  资源类
 * 2、判断  干活  通知
 *
 * 在多线程循环判断情况下，一定要使用(while)，而不是(if)关键字
 * 否则，结果会连续生产两次，或者连续消费两次，高并发情况下数据一致性不保证
 * 2个线程，操作5次，没问题
 * 4个线程，操作5次，也没问题
 * 8个线程，操作5次，出现问题
 * 在多线程情况下，多个线程抢锁，争抢资源，就会造成数据不一致性。
 * AA	 1
 * BB	 0
 * AA	 1
 * BB	 0
 * AA	 1
 * BB	 0
 * AA	 1
 * BB	 0
 * AA	 1
 * BB	 0
 * CC	 1
 * DD	 0
 * EE	 1
 * CC	 2
 * EE	 3
 * CC	 4
 * EE	 5
 * DD	 4
 * DD	 3
 * DD	 2
 * DD	 1
 * CC	 2
 * EE	 3
 * CC	 4
 * EE	 5
 * FF	 4
 * FF	 3
 * FF	 2
 * FF	 1
 * HH	 0
 * GG	 1
 * HH	 0
 * GG	 1
 * HH	 0
 * GG	 1
 * HH	 0
 * GG	 1
 * HH	 0
 * GG	 1
 * FF	 0
 *
 * Process finished with exit code 0
 */
public class ProducerConsumerTraditionalDemo {

    public static void main(String[] args) {

        ShareData shareData = new ShareData();

        new Thread(
                () -> {
                    for (int i = 1; i <= 5; i++) {
                        try {
                            shareData.increment();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, "AA"
        ).start();

        new Thread(
                () -> {
                    for (int i = 1; i <= 5; i++) {
                        try {
                            shareData.decrement();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, "BB"
        ).start();

        new Thread(
                () -> {
                    for (int i = 1; i <= 5; i++) {
                        try {
                            shareData.increment();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, "CC"
        ).start();

        new Thread(
                () -> {
                    for (int i = 1; i <= 5; i++) {
                        try {
                            shareData.decrement();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, "DD"
        ).start();

        new Thread(
                () -> {
                    for (int i = 1; i <= 5; i++) {
                        try {
                            shareData.increment();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, "EE"
        ).start();

        new Thread(
                () -> {
                    for (int i = 1; i <= 5; i++) {
                        try {
                            shareData.decrement();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, "FF"
        ).start();

        new Thread(
                () -> {
                    for (int i = 1; i <= 5; i++) {
                        try {
                            shareData.increment();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, "GG"
        ).start();

        new Thread(
                () -> {
                    for (int i = 1; i <= 5; i++) {
                        try {
                            shareData.decrement();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, "HH"
        ).start();

    }
}


/**
 * 共享资源类
 */
class ShareData {
    private int number = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();


    public void increment() throws Exception {

        lock.lock();
        try {
            //1.判断  多线程循环判断要用while,不能用if
            while(number != 0) {
                condition.await();
            }
            //2.干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t " + number);

            //3.通知唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {

        lock.lock();
        try {
            //1.判断 多线程循环判断要用while,不能用if
            while (number == 0) {
                condition.await();
            }
            //2.干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t " + number);

            //3.通知唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
