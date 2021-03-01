package com.wunderbar.jdk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Rommel
 * @date 2020/11/29 15:35
 * @description 测试一下高并发情况下
 * AtomicLong和LongAdder的性能对比
 * AtomicLong：Since1.5 底层是unsafe.getAndIncrement() ，CAS乐观锁思想
 * LongAdder：Since 1.8 ,底层通过继承Stripped64,在内存多申请Cell数组，以空间换时间，在高并发（并发线程多），数据累加次数多
 *            的情况下，LongAdder的耗时，性能明显比AtomicLong好很多
 *
 *            结果显示，在累加数量相同的情况下，并发线程少的情况下，甚至AtomicLong性能更好，但是，在线程数量大的多线程情况下
 *            明显LongAdder性能更好
 */
public class AtomicLongVSLongAdder {

    public static void main(String[] args) {
        testAtomicLongVSLongAdder(1,1000000);

        testAtomicLongVSLongAdder(20,1000000);

        testAtomicLongVSLongAdder(40,1000000);

        testAtomicLongVSLongAdder(80,1000000);

        testAtomicLongVSLongAdder(200,1000000);

    }

    public static void testAtomicLongVSLongAdder(final int threadCount,final int times){
        try {
            System.out.println("threadCount:"+threadCount+",times:"+times);
            long start = System.currentTimeMillis();
            testLongAdder(threadCount,times);
            System.out.println("LongAdder elapse:"+(System.currentTimeMillis()-start)+"毫秒");

            long start1 = System.currentTimeMillis();
            testAtomicLong(threadCount,times);
            System.out.println("AtomicLong elapse:"+(System.currentTimeMillis()-start1)+"毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试LongAdder
     * */
    static void testLongAdder(final int threadCount,final int times){
        LongAdder longAdder =new LongAdder();
        List<Thread> list =new ArrayList<>();
        for(int i=0;i<threadCount;i++){
            list.add(new Thread(()->{
                for (int j =0 ;j<times;j++){
                    longAdder.increment();
                }
            }));

        }

        for(Thread thread :list){
            thread.start();

        }

        for (Thread thread :list){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 测试AtomicLong
     * */
    static void testAtomicLong(final int threadCount,final int times){

        AtomicLong atomicLong =new AtomicLong();
        List<Thread> list =new ArrayList<>();
        for(int i = 0; i<threadCount;i++){
            list.add(new Thread(()->{
                for(int j=0;j<times;j++){
                    atomicLong.incrementAndGet();

                }
            }));

        }

        for (Thread thread :list){
            thread.start();
        }

        for (Thread thread:list){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
