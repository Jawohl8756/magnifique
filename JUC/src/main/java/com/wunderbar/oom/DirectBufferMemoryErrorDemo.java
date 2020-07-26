package com.wunderbar.oom;

import java.nio.ByteBuffer;

/**
 * @author Rommel
 * @date 2020/3/22 13:53
 * @description Java直接内存异常演示
 * JVM参数设置：
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 * 故障现象：
 *
 * 导致原因：
 * 写NIO程序经常使用ByteBuffer来读取或者写入数据，这是一种基于通道(Channel)与(Buffer)的IO方式
 * 它可以使用Native函数库直接分配堆外内存，然后通过一个存储在Java堆里面的DirectBuffer对象作为
 * 这块内存的引用进行操作
 * 这样能在一些场景中显著提高性能，因为避免了在Java堆和Native堆中来回复制数据。
 *
 * ByteBuffer.allocate(capacity) 第一种方式是分配JVM堆内存，属于GC管辖范围，由于需要拷贝所以速度相对较慢
 *
 * ByteBuffer.allocateDirect(capacity) 第一种方式是分配OS本地内存，不属于GC管辖范围，由于不需要内存拷贝所以速度相对较快
 *
 * 但如果不断分配本地内存，堆内存很少使用，那么JVM就不需要执行GC，DirectBuffer对象就不会被回收
 * 这时候内存充足，但是本地内存可能已经使用光了，再次尝试分配本地内存就会出现OutOfMemoryError,那么程序直接崩溃了。
 *
 *
 *
 *
 *
 */
public class DirectBufferMemoryErrorDemo {

    public static void main(String[] args) {

        System.out.println("配置的maxDirectMemory:"+(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"MB");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        //-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
        //堆外本地内存建造6M大的对象
        ByteBuffer byteBuffer =ByteBuffer.allocateDirect(6*1024*1024);
        //Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory

    }
}
