package com.wunderbar.queue;

import com.wunderbar.cas.TimeUtil;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author Rommel
 * @date 2020/3/4 21:43
 * @description 单一同步队列
 * 唯一消费-唯一生产，定制队列
 * <p>
 * 不存储元素的阻塞队列
 * <p>
 * 定义一个要消费的元素，生产一个元素，立刻取走，不阻塞。
 * <p>
 * 每一个put操作必须等待一个take操作，反之亦然。
 *
 * 先生产一块砖，再修筑长城
 * 先编织一个网眼，结合成一面大网来捕鱼
 *
 * 生产一个等待消费，不消费就不生产了。
 * 这是定制消费
 *
 * 敌不动我不动，敌动我动
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {

        //BlockingQueue<String> blockingQueue =new ArrayBlockingQueue<>(3);
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();//不存储，初始值就是0；

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "AAA").start();

        new Thread(() -> {
            try {
                TimeUtil.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t take 1");
                blockingQueue.take();

                TimeUtil.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t take 2");
                blockingQueue.take();

                TimeUtil.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t take 3");
                blockingQueue.take();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "BBB").start();


    }
}
