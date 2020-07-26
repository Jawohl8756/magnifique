package com.wunderbar.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Rommel
 * @date 2020/2/29 18:17
 * @description 高并发情况下，集合类线程不安全示例和解决方案
 * ArrayList Not Safe
 */
public class ArrayListNotSafeDemo {

    public static void main(String[] args) {
        //List<String> list = Arrays.asList("a","b","c");
        //list.forEach(System.out::println);

        //List<String> stringList = new ArrayList<>();
        //List<String> stringList = new Vector<>();
        //List<String> stringList = Collections.synchronizedList(new ArrayList<>());
        List<String> stringList = new CopyOnWriteArrayList<>();


        //stringList.add("a");
        //stringList.add("b");
        //stringList.add("c");
        //for (String element:stringList){
        //    System.out.println(element);
        //}

        for (int i = 1; i <= 30; i++) {
            new Thread(
                    () -> {
                        stringList.add(UUID.randomUUID().toString().substring(0, 8));
                        System.out.println(stringList);
                    }, String.valueOf(i)

            ).start();
        }

        /**
         * 不要只是会用，会用只是API调用工程师（调包侠），CRUD程序员，资深初级开发工程师，
         * 底层原理？？？？？
         * java.util.ConcurrentModificationException
         * 并发修改异常：快速失败
         * juc下面都是：安全失败
         * 1.故障现象
         *   java.util.ConcurrentModificationException
         *
         * 2.导致原因
         *
         * 3.解决方案
         * 3.1 new Vector();                   synchronized重量级别锁，保证数据一致性，但是并发性下降
         * 3.2 Collections.synchronizedList()  集合工具类的静态同步方法
         * 3.3 new CopyOnWriteArrayList<>();   写时复制ArrayList
         *   微信接龙一样的思想，第一个人开头，记下自己的名字，发到群里
         *   第二个人不用重新开头，直接复制前一个，在追加自己的名字，放在群里，以此类推。
         *
         * 写时复制:
         * CopyOnWrite容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器Object[]添加，而是先
         * 先将当前容器Object[]进行copy,复制出一个新的容器Object[] newElements,然后新的容器object[] newElements
         * 里添加元素，添加完元素之后，再将原容器的引用指向新的容器 setArray(newElements)
         * 这样做的好处是可以对copyOnWrite容器进行并发的读，而不需要加锁，因为当前容器不回添加任何元素。所以CopyOnWrite
         * 容器也是一种读写分离的思想，读和写不同的容器
         *
         *  public boolean add(E e) {
         *         final ReentrantLock lock = this.lock;
         *         lock.lock();
         *         try {
         *             Object[] elements = getArray();
         *             int len = elements.length;
         *             Object[] newElements = Arrays.copyOf(elements, len + 1);
         *             newElements[len] = e;
         *             setArray(newElements);
         *             return true;
         *         } finally {
         *             lock.unlock();
         *         }
         *     }
         *
         * 4.优化建议（同样问题不出现第2次）
         *
         *
         *
         *
         * */
    }
}
