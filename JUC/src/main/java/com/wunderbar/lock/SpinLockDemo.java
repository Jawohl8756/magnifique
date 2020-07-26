package com.wunderbar.lock;

import com.wunderbar.cas.TimeUtil;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Rommel
 * @date 2020/3/1 19:59
 * @description 自旋锁 示例
 * 自旋锁，不原地阻塞，而是循环比较，时常回来询问尝试获取锁
 * 自旋锁的好处:循环比较，直到获取成功为止，没有类似wait的阻塞。
 * <p>
 * 通过CAS操作完成自旋锁，A线程先进来，调用myLock方法，自己持有锁5s
 * 线程B进来发现，当前有线程持有锁。不是null,所以通过自旋等待，知道A释放锁后
 * B随后抢到。
 */
public class SpinLockDemo {
    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t has came in ...");
        while (!atomicReference.compareAndSet(null, thread)) {
        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\t has invoked unlock ...");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        //线程AA
        new Thread(() -> {
            //拿到资源，加锁
            spinLockDemo.myLock();
            //持有锁5ms
            try {
                TimeUtil.SECONDS.sleep(10000);//aa线程先进来，持有锁10s之后，才释放锁。释放之前，同时进来的线程BB一直在自旋，询问尝试获取锁。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //打开锁，释放资源
            spinLockDemo.myUnLock();
        }, "AA").start();

        //AA线程停一会
        try {
            TimeUtil.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //线程BB
        new Thread(() -> {
            //进来，加锁，占有资源
            spinLockDemo.myLock();
            //持有资源1ms
            try {
                TimeUtil.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //释放资源
            spinLockDemo.myUnLock();
        }, "BB").start();

    }
}
