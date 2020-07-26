package com.wunderbar.cas;

import sun.util.locale.provider.TimeZoneNameUtility;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.newThread;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

/**
 * @author Rommel
 * @date 2020/2/27 12:24
 * @description ABA问题的解决方案
 * AtomicStampedReference
 */
public class ABADemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<Integer>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {

        System.out.println("=============以下是ABA问题的产生场景================");
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                TimeUtil.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019) + "\t current data is :" + atomicReference.get());
        }, "t2").start();


        try {
            TimeUtil.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=============以下是ABA问题的解决方案==============");
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 的第1次版本号:" + stamp);
            //暂停1秒种t3线程
            try {
                TimeUtil.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 的第2次版本号:" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 的第3次版本号:" + atomicStampedReference.getStamp());

        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 的第1次版本号:" + stamp);
            //暂停3秒种t4线程
            try {
                TimeUtil.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean flag = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "\t 修改成功否:" + flag + "\t当时最新实际版本号为:" + atomicStampedReference.getStamp());


            System.out.println(Thread.currentThread().getName() + "\t 当前实际最新值:" + atomicStampedReference.getReference());
        }, "t4").start();


    }
}
