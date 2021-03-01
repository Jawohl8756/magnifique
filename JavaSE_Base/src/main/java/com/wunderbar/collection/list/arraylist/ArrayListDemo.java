package com.wunderbar.collection.list.arraylist;

import java.util.ArrayList;

/**
 * @author Rommel
 * @date 2021/1/2 13:51
 * @description List接口的主要实现类
 * ArrayList，基于对象数据Object[]实现的List,内存连续，有下角标index,查询快速复杂度O(1),删除复杂度O(N)
 * 有序，元素可重复
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        //根据下角标插入
        insertWithIndex();
        //根据下角标删除
        //removeWithIndex();
        //直接删除对象
        //removeWithObject();
    }

    /**
     * Inserts the specified element at the specified position in this
     * list
     * 在指定的位置，插入指定的元素
     * */
    private static void insertWithIndex() {
        ArrayList<String> list =new ArrayList<>();
        list.add("ich");
        list.add("bin");
        list.add("ihrer");
        list.add("vater");
        System.out.println("Before This list ="+list);

        //空的list直接在指定index加元素，报异常，躲不过边界校验forAdd
        list.add(2,"da");//长度++，元素后移
        list.set(2,"dddd");//原地替换，数量不变
        System.out.println("After This list ="+list);


    }

    /**
     * remove(Object o)
     *删除对象的步骤：
     * 1.对参数Object o进行非空判断，不是index的rangeCheck边界检查.
     * 2.如果对象o为null,遍历循环对象数组的每一个值，置为null.
     *   elementData[index]=null.
     * 3.进行fastRemove(),不进行数组越界和参数非空校验的检查了，直接记录修改次数和算出移动距离，进行数组拷贝.
     * 4.如果对象o不为null,遍历循环对象数组的每一个值，值等于传入对象o.
     * 5.进行fastRemove(),不进行数组越界和参数非空校验的检查了，直接记录修改次数和算出移动距离，进行数组拷贝.
     * 6.最后的数组对象元素置为null.
     * 7.fastRemove()和remove()方法的区别就是，不再进行参数的数组越界和参数非空校验了，因为已经在前端做过了。
     * */
    private static void removeWithObject() {
        //创造存对象的ArrayList
        ArrayList<Object> list =new ArrayList<>();
        list.add(new Integer(0));
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(4));
        list.add(new Integer(5));
        list.add(new Integer(6));

        System.out.println("Before This list=" + list);
        list.remove(new Integer(2));
        System.out.println("After This list =" + list);


    }

    /**
     * remove(int index)
     * debug，在要触动的方法出打断点，会看到ArrayList初始化的容量，和扩容后的容量（Object[]数组的长度）
     *
     * 删除的步骤：
     * 1.进行参数index校验
     * 2.记录集合操作次数modCount ++
     * 3.取出index处的元素
     * 4.计算移动的长度num =size-index-1
     * 5.系统类进行arraycopy
     * 6.最后一个元素置null
     * 7.返回要删除的oldValue
     * */
    public static void removeWithIndex() {
        //创造存基本类型的ArrayList，支持根据下角标index删除
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);

        System.out.println("Before This list=" + list);
        list.remove(2);
        System.out.println("After This list =" + list);

    }
}
