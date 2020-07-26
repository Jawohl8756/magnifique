package com.wunderbar.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Rommel
 * @date 2020/2/29 20:30
 * @description HashSet也不是线程安全的
 */
public class HashSetNotSafeDemo {

    public static void main(String[] args) {
        //Set<String> stringSet = new HashSet<>();
        //Set<String> stringSet = Collections.synchronizedSet(new HashSet<>());
        Set<String> stringSet = new CopyOnWriteArraySet<>();

        /**
         *  private final CopyOnWriteArrayList<E> al;
         *
         *  public CopyOnWriteArraySet() {
         *   al = new CopyOnWriteArrayList<E>();
         *   }
         * 底层还是CopyOnWriteArrayList
         * 两个牌子，一个戏班子
         *
         * 一起走过的日子
         * 来生缘
         * 不同的歌词，一样的曲调
         *
         * */

        new HashSet<>().add("String");//HashSet增加元素，个数是1，底层是HashMap
       /* 那是因为
        *   public boolean add(E e) {
        *    return map.put(e, PRESENT)==null;
        * }
        * 而value的值是常量PRESENT,
        * private static final Object PRESENT = new Object();
        * 每次增加，只增加key ：e就好了。
        *
        * */

        new HashMap<>().put("String","str");//HashMap新增元素要加2个，k/v键值对

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                stringSet.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(stringSet);
            }, String.valueOf(i)).start();
        }
    }
}
