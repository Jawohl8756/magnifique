package com.wunderbar.volatilee;

/**
 * @author Rommel
 * @date 2020/2/29 14:56
 * @description 单例模式
 * 懒汉模式和饿汉模式
 */
public class SingletonDemo {
    //加volatile 和DCL保证双端数据一致性和并发性
    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t我是类私有构造器，防止随意new对象....");
    }

    /**
     * 加synchronized关键字可以保证数据一致性
     * 但是并发性没有得到保证
     * synchronized关键字，重量级锁。
     *
     * DCL Double Check Lock双端检锁机制
     *
     * DCL + Volatile 进行双端校验，保证数据一致性和并发性
     *
     * 进地铁安检，出地铁安检
     *
     * */
    public static SingletonDemo getInstance() {
        if (instance == null) { //头端检锁验证

            synchronized (SingletonDemo.class){
                if (instance==null){//尾端检锁验证
                    instance = new SingletonDemo();  //不在方法上加synchronized,只在构造方法上面加锁
                }

            }
           // instance = new SingletonDemo();   synchronized代码块锁住类，把36行的new 对象放到32行

        }
        return instance;
    }

    public static void main(String[] args) {
        //SingletonDemo singletonDemo = new SingletonDemo();
        //System.out.println("当前类对象是:" + singletonDemo.getInstance());
        //单线程main线程的主动操作
        //System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        //System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        //System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());

        //并发多线程的操作后，情况发生了很大的变化
        for (int i = 1; i <= 10; i++) {
            new Thread(
                    () -> {
                        SingletonDemo.getInstance();
                    }, String.valueOf(i)
            ).start();

        }

    }
}
