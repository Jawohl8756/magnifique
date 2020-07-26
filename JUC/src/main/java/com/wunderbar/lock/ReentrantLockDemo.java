package com.wunderbar.lock;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.wunderbar.cas.TimeUtil;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Rommel
 * @date 2020/3/1 15:40
 * @description 可重入锁验证
 * 可重入锁是指：同一线程外层函数获取锁之后，内层递归函数仍能够获取该锁的代码
 * 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 * <p>
 * 也即是说，线程可以获取任何一个它已经拥有的锁锁同步着的代码块。
 * <p>
 * 线程操纵资源类
 * case one synchronized是典型的可重入锁
 * 11	 发送短信......    11线程在外层方法获取锁的时候
 * 11	 发送邮件......    11在进入内层方法会自动获取锁
 * 12	 发送短信......
 * 12	 发送邮件......
 * 线程11能访问加锁的代码块（短信），如果这个代码块里面也有另一个加锁的方法作为领一个代码块（邮件）
 * 那么线程11顺带也能访问这个代码块（发邮件）
 * <p>
 * case two ReentrantLock是可重入锁
 */
public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        //synchronized测试
        new Thread(() -> {
            try {
                phone.sendEMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendEMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        TimeUtil.SECONDS.sleep(3);

        //ReentrantLock测试
       /* new Thread(() -> {
            try {
                get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t3").start();*/
        Thread t3 =new Thread(phone,"t3");
        Thread t4 =new Thread(phone,"t4");
        t3.start();
        t4.start();

    }
}

class Phone implements Runnable {
    //场景一：synchronized是可重入锁
    public synchronized void sendEMS() throws Exception {
        System.out.println(Thread.currentThread().getId() + "\t 发送短信......");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getId() + "\t 发送邮件......");
    }

    //场景二：ReentrantLock是可重入锁
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();

    }


    /**
     * 既然2个方法set /get都是可重入锁ReentrantLock修饰
     * 那么线程进入get方法代码块，这个代码块里面又调用了set方法
     * 线程自然也可以继续调用set方法代码块里面的代码，这就是可重入锁。
     *
     * */
    private void get() {
        //申请加锁2次
        lock.lock();
        lock.lock();
        try {

            System.out.println(Thread.currentThread().getName() + "\t invoked get() method....");
            set();
        } finally {
            //申请释放锁两次  ，两两配对，数量一致
            lock.unlock();
            lock.unlock();


            /**
             * 加锁两次，就要释放锁两次，如果只释放一次，那程序就不启动t4线程，程序卡死
             * 如果加锁一次，释放两次，那就报异常，程序退出。
             *
             * */
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked set() method....");
        } finally {
            lock.unlock();
        }
    }


}
