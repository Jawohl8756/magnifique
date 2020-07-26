package com.wunderbar.oom;

/**
 * @author Rommel
 * @date 2020/3/22 15:06
 * @description 高并发场景下：无法创建新的本地线程异常
 * <p>
 * 高并发请求服务器时，经常出现以下异常：java.lang.OutOfMemoryError:unable to create new native thread
 * 准确来讲，该native thread 异常与对应的平台有关。
 * 导致原因：
 * 1.你的应用创建了太多的线程，一个应用进程创建多个线程，超过系统承载极限。
 * 2.你的服务器并不允许你的应用程序创建这么多线程，Linux系统默认允许单个进程可以创建的线程数时候1024个，
 * 你的应用创建线程超过这个数量，就会报：java.lang.OutOfMemoryError:unable to create new native thread
 * <p>
 * 解决办法：
 * 1.想办法降低你的应用程序创建线程的数量，分析应用是否真的需要创建这么多线程，如果不是，修改代码将线程数量降到最低
 * 2.对于有的应用，确实需要创建很多的线程，远超过Linux系统默认的1024个线程的限制，可以通过修改Linux服务器的配置，扩大默认限制
 */
public class UnableToCreateNewNativeThreadErrorDemo {

    public static void main(String[] args) {

        for (int i = 0; ; i++) {//没有出口，不能的new Thread()
            System.out.println("*********i=" + i);
            new Thread(() -> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "thread-" + i).start();

        }
        // java javac ,在Linux操作系统下执行这个类，验证 1024 最大线程数量

    }
}
