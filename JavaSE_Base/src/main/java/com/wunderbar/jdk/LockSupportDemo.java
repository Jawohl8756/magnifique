package com.wunderbar.jdk;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Rommel
 * @date 2020/12/5 21:29
 * @description LockSupport#park()
 * #unpark()
 * <p>
 * UNSAFE .
 */
public class LockSupportDemo {
    public static void main(String[] args) {

        //打乱通知和阻塞的顺序
        /*
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */


        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":coming in------");
            /**
             * 线程被阻塞，等待被唤醒，等待拿到permit 1，等待被放行
             *
             * 根本用synchronized代码块和lock()/unlock
             * 执行顺序怕被打断，
             *
             * #park();
             * permit =0 ，只有一个，只发行一次，多次阻塞，死锁，线程跑死，影响结果。
             *
             */
            LockSupport.park();
            //LockSupport.park();


            System.out.println(Thread.currentThread().getName() + ":被唤醒。。。。");
        }, "t1");
        t1.start();


        /**
         * 延时
         * 可以unpark在park之前执行，完全没问题
         * */
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(() -> {
            /**
             * 线程t2通知放行线程t1，t1拿到许可证（0,1）,不再被阻塞，可以被放行了
             *
             * #unpark(Thread t)
             * permit =1
             * 只能放行一次，多次放行无用，不影响结果
             */
            LockSupport.unpark(t1);
            LockSupport.unpark(t1);

            System.out.println(Thread.currentThread().getName() + ":通知了。。。。");
        }, "t2");
        t2.start();


    }
}
