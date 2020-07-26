package com.wunderbar.volatilee;

import com.wunderbar.cas.TimeUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Rommel
 * @date 2020/2/27 21:03
 * @description Volatile内存可见性
 *
 */
public class VisibleVolatileDemo {

    public static void main(String[] args) {
        {
            MyData myData = new MyData();//数据资源类

            //AAA线程
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t come in ...");
                try {
                    TimeUtil.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myData.addTo60();
                System.out.println(Thread.currentThread().getName() + "\t updated number value：" + myData.num);

            }, "AAA").start();

            /**
             * 第二个线程是main主线程，变量num没加volatile的时候，没人通知内存中的变量值，变量值不可见，
             * 主线程一直在这里循环等待，不会打印42行的提示语。
             *
             * 如果数据源中的变量num加上volatile修饰，内存可见性，一旦有线程修改这个变量的值
             * 其他线程，如主线程就会知道最新值，不会死死等待，循环挂起，就会打印42 45 行代码
             *
             */

            while (myData.num==0){
            }
            //main线程一直在这里等待，知道num的值等于60
            System.out.println(Thread.currentThread().getName()+"\t mission is over...");

            System.out.println(Thread.currentThread().getName()+"\t main get num value:"+myData.num);
        }
    }
}

