package com.wunderbar.threadpool;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @author Rommel
 * @date 2020/3/7 16:48
 * @description 线程池示例
 *
 * 理论 ->编码 ->小总结
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        //此电脑-属性-设备管理器-处理器
        System.out.println("本机服务器的核数量:"+Runtime.getRuntime().availableProcessors());
        //基础线程池初始化
        //threadPoolInit();

        //禁止Executors.newFixed/newSingle.cached
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,        //核心线程数
                5,   //最大线程数
                1L,      // 扩展线程响应时间
                TimeUnit.SECONDS,     //时间单位
                new LinkedBlockingQueue<Runnable>(3),  //等待队列
                Executors.defaultThreadFactory(),               //线程工厂
                //new ThreadPoolExecutor.AbortPolicy()            //默认拒绝策略，all out ，直接决绝，崩溃所有
                //new ThreadPoolExecutor.CallerRunsPolicy()       //不直接拒绝，超出的线程打回回调处，主线程发过来的，多余的2个线程让调用者main线程处理
                //new ThreadPoolExecutor.DiscardOldestPolicy()    //抛弃等待时间最久的，不报错，但还是只执行8个
                new ThreadPoolExecutor.DiscardPolicy()           // 10个线程，超出2个，随意丢弃2个线程，仍然执行8个线程
        );

        try {
            //线程请求数量超过最大线程数+队列容量（5+3），就会启动拒绝机制
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 来办业务了");
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


    }

    //基础线程池初始化
    private static void threadPoolInit() {
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);//一个池，5个线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        ExecutorService threadPool = Executors.newCachedThreadPool();

        //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程，就是10个请求线程
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 来办理业务");

                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
