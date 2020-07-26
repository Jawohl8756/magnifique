package com.wunderbar.threadpool;

import javax.naming.Name;
import java.lang.annotation.Target;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Rommel
 * @date 2020/3/6 18:23
 * @description 实现线程的第三种方式Callable接口
 *
 * ForkJoin 分而治之，大事化小，小事化了
 * 大数据思想
 *
 *
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask =new FutureTask<Integer>(new MyThread());
        Thread t1 =new Thread(futureTask,"AA");
        t1.start();

        int result01 =100;
        int result02= futureTask.get();//建议放在最后处理。要求会的Callable接口线程的计算结果，如果没有计算完成就去强求，会导致阻塞，直到计算完成。


        System.out.println("**********result:" + (result01+result02));


        //new Thread(()->{
        //},"BB").start();

    }
}

/**
 * 方法三:实现Callable接口。
 * 有两个好处：
 * 1.有返回值，能计算
 * 2.能抛异常，知道线程错误的原因
 *
 * */
class MyThread implements Callable<Integer>
{

    @Override
    public Integer call() throws Exception {
        System.out.println("*******Callable interface comes in ********");
        return 1024;
    }
}

/**
 * 方法一：继承Thread类
 * Java类单继承，多实现
 * Java接口可以多继承
 *
 * 接口是特殊的类
 * 抽象类告诉你他是什么种类
 * 接口告诉你这类东西能干什么
 *
 *
 * */
class MyThread2 extends Thread{

}
/**
 * 方法二：实现Runnable接口，无返回值
 * */
class MyThread1 implements Runnable{

    @Override
    public void run() {

    }
}
