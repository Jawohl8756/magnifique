package com.wunderbar.volatilee;

/**
 * @author Rommel
 * @date 2020/2/27 21:07
 * @description volatile 不保证原子性
 * 使用juc.atomic包下面的辅助类进行原子操作
 * AtomicInteger
 * AtomicLong
 * AtomicBoolean
 *
 * AtomicReference<V>使用泛型定制化原子对象
 */
public class NotAtomicVolatileDemo {

    public static void main(String[] args) {

        {
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
}
