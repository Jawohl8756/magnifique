package com.wunderbar.BuildModel.IteratorPattern;


/**
 * @author Rommel
 * @date 2020/3/15 21:37
 * @description
 */
public interface Iterator {
    //指针前移
    Object previous();

    //指针后移
    Object next();

    //是否有下一个元素
    boolean hasNext();

}
