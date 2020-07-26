package com.wunderbar.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Rommel
 * @date 2020/2/25 18:07
 * @description  CAS :Compare And Swap
 * 比较并交换
 */
public class CASDemo
{

    public static void main(String[] args)
    {
        AtomicInteger atomicInteger =new AtomicInteger(5);

        /**
         * 主物理内存的初始化值是:5
         * 第一个线程把主物理内存里面的变量值5 copy到自己的工作内存
         * 比较5 == 5 ，true ,就进行重新赋值 :5-->2020
         *
         *第二个线程把主物理内存里面的变量值2020 copy到自己的工作内存
         * 比较5 ！== 2020 ，false ,比较不为true,就不会进行重新赋值,2000 重新放回主内存
         *
         * */
        System.out.println(atomicInteger.compareAndSet(5, 2020)+"\t current data in main memory:"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2020)+"\t current data in main memory:"+atomicInteger.get());
        //多线程环境不能使用i++ ,这线程不安全；使用AtomicInteger.getAndIncrement()方法，没有synchronized关键字夜恩能够线程安全
        //20多个线程轮流加变量，最后的值也是正确的。
        atomicInteger.getAndIncrement();
    }
}
