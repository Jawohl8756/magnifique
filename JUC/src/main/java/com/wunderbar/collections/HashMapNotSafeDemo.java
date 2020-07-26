package com.wunderbar.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Rommel
 * @date 2020/2/29 20:59
 * @description HashMap线程不安全
 *
 * Java设计思想，体系的力量
 * 主要的集合List Set Map
 * 为了并发性，操作效率，牺牲了线程安全
 * 在高并发情况下，都不是绝对线程安全的
 * ArrayList 线程不安全，有CopyOnWriteArrayList
 * HashSet   线程不安全，有CopyOnWriteArraySet(底层还是CopyOnWriteArrayList),HashSet底层是HashMap,put(add)的时候，只新增key(e),value是常量PRESENT
 *
 * HashMap   线程不安全，有CopyOnWriteHashMap？？？？没有，有ConcurrentHashMap(底层分段加锁，整体就是加锁了)
 *
 * 都可以用Collections.synchronizedXXX()方法进行同步操作，保证线程安全
 *
 *
 */
public class HashMapNotSafeDemo {

    public static void main(String[] args) {
        //Map<String,String> map =new HashMap<>();
        //Map<String,String> map = Collections.synchronizedMap(new HashMap<String,String>());
        Map<String,String> map =new ConcurrentHashMap<>();

        for (int i=1;i<=30;i++){
            new Thread(
                    ()->{
                        map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                        System.out.println(map.toString());
                    }
                    ,String.valueOf(i)
            ).start();
        }
    }
}
