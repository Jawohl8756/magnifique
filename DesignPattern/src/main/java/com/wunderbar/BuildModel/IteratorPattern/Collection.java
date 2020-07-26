package com.wunderbar.BuildModel.IteratorPattern;

/**
 * @author Rommel
 * @date 2020/3/15 21:10
 * @description 集合接口
 */
public interface Collection {
    //元素迭代
    Iterator iterator();

    //根据下角标获取元素
    Object get(int i);

    //向集合元素中添加元素
    boolean add(Object o);

    //获取集合元素的大小
    int size();

}
