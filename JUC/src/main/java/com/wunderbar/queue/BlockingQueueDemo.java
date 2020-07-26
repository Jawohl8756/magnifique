package com.wunderbar.queue;

import com.wunderbar.cas.TimeUtil;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Rommel
 * @date 2020/3/4 16:27
 * @description 阻塞队列 示例
 * <p>
 * 1.队列
 * 2.阻塞队列
 * 2.1 阻塞队列有没有好的一面
 * 2.2 不得不阻塞，如何管理
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        // List list =new ArrayList();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(4);
        System.out.println(blockingQueue.add("ich"));
        System.out.println(blockingQueue.add("bin"));
        System.out.println(blockingQueue.add("ihrer"));
        System.out.println(blockingQueue.add("Vater"));

        blockingQueue.clear();

        System.out.println(blockingQueue.offer("I"));
        System.out.println(blockingQueue.offer("am"));
        System.out.println(blockingQueue.offer("the"));
        System.out.println(blockingQueue.offer("best"));
        System.out.println(blockingQueue.offer("one"));//越界插入不报异常，报false

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());//插入为false,取出的也就为null

        blockingQueue.clear();

        blockingQueue.put("wir");
        blockingQueue.put("sind");
        blockingQueue.put("der");
        blockingQueue.put("Nacht");
        //System.out.println("========");
        //blockingQueue.put("JA");//满了再加，一直阻塞到有空间为止。阻塞到可以生产为止--------------死战不退

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        System.out.println("++++++");
        //blockingQueue.take();//掏空之后，再取，阻塞到队列有新的元素到来为止。阻塞到重新消费到为止--------不见不散

        blockingQueue.clear();

        System.out.println(blockingQueue.offer("where", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("there", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("is", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("will", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("coolboy", 2L, TimeUnit.SECONDS));


    }
}
