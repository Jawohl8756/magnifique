package com.wunderbar.jvm;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author Rommel
 * @date 2020/3/20 16:42
 * @description GCRoot引用可达，才不会被回收
 * 在Java中可作为GCRoots的对象有：
 * 1.虚拟机栈（栈帧中的本地变量表）中引用的对象
 * 2.方法区中的类静态属性引用的对象
 * 3.方法区中的常量引用的对象
 * 4.本地方法栈中的JNI（即一般说的Native方法）
 */
public class GCRootDemo {

    private byte[] byteArray = new byte[1024 * 2018];


    private static GCRootDemo g2;

    private static final GCRootDemo g3 = new GCRootDemo();


    public static void m1() {
        GCRootDemo g1 = new GCRootDemo();
        System.gc();
        System.out.println("第一次GC完成....");

    }

    public static void main(String[] args) {
        m1();
    }

}
