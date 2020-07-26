package com.wunderbar.jvm;

import java.time.Year;

/**
 * @author Rommel
 * @date 2020/3/20 17:44
 * @description GC打印字符串
 */
public class HelloGC {



    public static void main(String[] args) throws InterruptedException {
        System.out.println("**********HelloGC*************");
        Thread.sleep(Integer.MAX_VALUE);
        //   -Xms10m -Xmx10m        只分配10m内存
        //byte[] byteArray =new byte[50*1024*1024];//50m大对象，直接oom 会打印GC回收日志

        //long totalMemory =Runtime.getRuntime().totalMemory();
        //long maxMemory =Runtime.getRuntime().maxMemory();
        //System.out.println("TOTAL_MEMORY(-Xms)="+totalMemory+"(字节)、"+(totalMemory/(double)1024/1024)+"MB");
        //System.out.println("MAX_MEMORY(-Xmx)="+maxMemory+"(字节)、"+(maxMemory/(double)1024/1024)+"MB");


    }
}
