package com.wunderbar.producerconsumer;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import com.wunderbar.cas.TimeUtil;

import java.sql.SQLOutput;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Rommel
 * @date 2020/3/6 16:38
 * @description 生产者和消费者的阻塞队列版
 * <p>
 * volatile/cas/AtomicInteger/BlockingQueue/线程交互/原子引用
 * <p>
 * 构造器，传接口，不传类
 * 写足够抽象
 * 落地日志，足够详细
 */
public class ProducerConsumerBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //声明参数传接口，new对象赋值的时候，传子类，实现类，越具体越好。
        MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t生产线程启动");
            try {
                myResource.myProduct();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "myProduct").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t消费线程启动");

            try {
                myResource.myConsumer();
                System.out.println();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "myConsumer").start();


        TimeUtil.SECONDS.sleep(5);
        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println("大老板叫停一切生产消费活动.....");
        myResource.stop();


    }
}

class MyResource {
    private volatile boolean FLAG = true;//默认开启，进行生产和消费

    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    /**
     * 生产数据
     */
    public void myProduct() throws Exception {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 生产并插入阻塞队列蛋糕" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 生产并插入阻塞队列蛋糕" + data + "失败");

            }
            TimeUtil.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t 大老板叫停，表示FLAG =FALSE,停止生产。。。");
    }


    /**
     * 消费数据
     */
    public void myConsumer() throws Exception {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")) {
                FLAG = false;//高挂免战牌，我也不继续消费了，回家了，不买了
                System.out.println(Thread.currentThread().getName() + "\t 超过2s中没有取到蛋糕，消费退出！");
                System.out.println();
                System.out.println();

                return;//一定要return ,退出程序，否则阻塞，等等等。。。
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费到蛋糕" + result + "成功！");

        }


    }

    /**
     * 停止一切
     */

    public void stop() {
        this.FLAG = false;
    }


}
