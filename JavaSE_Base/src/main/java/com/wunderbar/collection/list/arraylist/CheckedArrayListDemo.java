package com.wunderbar.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Rommel
 * @date 2021/1/4 15:50
 * @description 提早检查容器的泛型元素为某种类型的。
 * 不要等到运行时在编译报错
 * @see java.util.Collections#checkedList(List, Class)
 */
public class CheckedArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("je");
        list.add("suis");
        list.add("la");

        /**
         * 不安全的场景：
         * 本来泛型为String的List只能放String
         * 通过赋值给更高界别的父类类型的List,
         * 便可以添加同兄弟类型的数据，穿透了原来的ArrayList<String>泛型，为数据不安全。
         * */
        List unsafeList = list;
        unsafeList.add(123);
        //没有提前泛型检查，编译通过，正常运行
        System.out.println("list add another type of Element:"+unsafeList);

        /**
         * 解决办法:
         * @see java.util.Collections#checkedList(List, Class)
         *提前指定元素必须为什么class类型的
         *
         * @throw java.lang.ClassCastException
         *
         * Collection.checkedList(),方法内部判断是不是 RandomAccess
         * 如果是，重新new 一个静态内部类：new CheckedRandomAccessList<>(list, type)
         * 这个静态内部类调用super父类方法->static class CheckedRandomAccessList<E> extends CheckedList<E>
         *     父类是CheckedList<E>,继续看它的静态方法，它的构造方法也是调用了父类
         *      static class CheckedList<E>
         *         extends CheckedCollection<E>
         *             干活的是CheckedCollection<E>
         *                 这个类本身没有extends，就是终极处理类了，没有父类了
         *                 @SuppressWarnings("unchecked")
         *         E typeCheck(Object o) {
         *             if (o != null && !type.isInstance(o))
         *                 throw new ClassCastException(badElementMsg(o));
         *             return (E) o;
         *         }
         *
         *         private String badElementMsg(Object o) {
         *             return "Attempt to insert " + o.getClass() +
         *                 " element into collection with element type " + type;
         *         }
         * */
        List safeList = Collections.checkedList(list, String.class);
        safeList.add(123);
        System.out.println("After checkedList operation:" + safeList);


    }
}
