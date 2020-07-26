package com.wunderbar.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rommel
 * @date 2020/3/22 13:05
 * @description Java GC Overhead Exceed Error
 * JVM参数配置演示
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 * <p>
 * GC回收时间过长时会抛出OutOfMemoryError.过长的定义是，超过98%的时间用来做GC并且回收了不到2%的堆内存
 * 连续多次GC都只回收了不到2%的极端情况下才会抛出。假如不抛出GC Overhead Limit错误会发生什么情况呢？
 * 那就是GC清理的这么点内存很快就会被再次填满，迫使GC再次执行，这样就形成恶性循环，CPU使用率一直是100%，
 * 而GC没有任何成果。
 * <p>
 * 事倍(98%的时间)功半(2%堆内存被清理回收)
 * 执行不力
 */
public class GCOverheadErrorDemo {

    public static void main(String[] args) {
        int i = 0;

        List<String> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
                //Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded

            }
        } catch (Throwable e) {//这里就不能是Exception ，级别不够，Throwable统领了Exception和Error
            System.out.println("***************i=" + i);
            e.printStackTrace();

            throw e;
        }
    }
}
