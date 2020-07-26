package com.wunderbar.threadpool;

import com.wunderbar.cas.TimeUtil;
import lombok.SneakyThrows;

/**
 * @author Rommel
 * @date 2020/3/7 21:22
 * @description 线程死锁demo
 *
 * 线程死锁是指两个或者两个以上的进程在执行过程中，
 * 因争夺资源而造成的一种互相等待的状况，
 * 若无外力干涉，他们都无法推进下去。
 *
 * 吃着碗里瞧着锅里，鹬蚌相争，相持不下
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA,lockB),"线程AAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"线程BBB").start();

    }
}

/**
 * 持有锁线程
 * */
class HoldLockThread implements Runnable{

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有:"+lockA+"\t 尝试获取:"+lockB);

            TimeUtil.SECONDS.sleep(3);

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有:"+lockB+"\t 尝试获取:"+lockA);
            }
        }

    }
}