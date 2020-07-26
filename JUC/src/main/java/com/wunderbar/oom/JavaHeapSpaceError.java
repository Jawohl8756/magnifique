package com.wunderbar.oom;

import java.util.Random;

/**
 * @author Rommel
 * @date 2020/3/21 21:08
 * @description Java堆空间异常演示
 */
public class JavaHeapSpaceError {


    //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    public static void main(String[] args) {
       /* String str = "rommel";

        while (true) {
            str += str + new Random().nextInt(11111) + new Random().nextInt(33333);
            str.intern();
        }*/


       // -Xms10m -Xms10m           初始堆内存和最大堆内存10m，声明一个80m大对象，立马Java heap space
        byte[] byteArray =new byte[70*1024*1024];
    }

}
