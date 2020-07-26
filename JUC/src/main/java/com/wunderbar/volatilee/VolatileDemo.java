package com.wunderbar.volatilee;

import com.wunderbar.cas.TimeUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Rommel
 * @date 2020/2/27 16:02
 * @description Volatile是Java虚拟机提供的轻量级同步机制
 * <p>
 * volatile 三大特性：
 * 1.保证可见性
 * 2.不保证原子性
 * 3.禁止指令重排
 *
 * 1.验证volatile的可见性
 * 1.1 假如int num =0 ;,num变量之前根本没有添加volatile关键字修饰，没有可见性
 * 1.2 添加了volatile关键字，可以解决可见性问题
 *
 * 2.验证volatile不保证原子性
 * 2.1 Atomic 原子性，不可分割的，完整性，也即某个线程正在做某个具体业务时，中间不可以加塞或者分割。需要完整，
 * 要么同时成功，要么同时失败。类似事务，一荣俱荣，一损俱损。
 * 2.2 volatile不保证原子性的代码演示
 * 2.3 why ?
 * 2.4 如何解决原子性？
 * 2.4.1 加重量级锁 关键字synchronized ,杀鸡用牛刀，高射炮打蚊子
 * 2.4.2 java.util.concurrent.atomic Doug Lea
 *       AtomicInteger AtomicLong AtomicBoolean
 *       根据泛型定制原子引用
 *       AtomicReference<V>: AtomicReference<User> AtomicReference<Order>
 *
 */
public class VolatileDemo {

    public static void main(String[] args) {
        //VisibleVolatile();//Volatile 的可见性


        atomicVolatile();//volatile不保证原子性，需要juc.atomic原子类（cas unsafe ,自旋转锁）配合使用

    }



    // 1.volatile的可见性
    private static void VisibleVolatile() {
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

    // 2.volatile的不保证原子性
    private static void atomicVolatile() {
        MyData myData =new MyData();
        //准备20个线程，
        for (int i=1;i<=20;i++){
            new Thread(()->{
                for (int j=1;j<=1000;j++){
                    myData.addPlusPlus(); //普通的i++不保证原子性
                    myData.addAtomic(); // Atomic保证原子性
                }

            },String.valueOf(i)).start();

        }


        //需要等待上面20个线程都计算完毕，再用main线程统计最终的结果
        //线程停止5秒之后主线程再汇总计算
        while (Thread.activeCount()>2){//默认main线程和后台gc线程,所以才是2个
            Thread.yield();
        }
       /* try {
            TimeUtil.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //如果volatile关键字保证了原子性，最终的变量结果应该是20X1000=2W,实际上可能是20000，但多少情况下，值是小于20000的
        System.out.println(Thread.currentThread().getName()+"\t finally num counted is :"+myData.num);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger Type ,finally num counted is :"+myData.atomicInteger);
    }


}



class MyData {
    volatile int num = 0;

    public void addTo60() {
        this.num = 60;
    }

    public void addPlusPlus(){
        num++;

    }

    // i++ 不保证原子性，使用AtomicInteger
    AtomicInteger atomicInteger =new AtomicInteger();
    public void addAtomic(){
        atomicInteger.getAndIncrement();

    }
}
