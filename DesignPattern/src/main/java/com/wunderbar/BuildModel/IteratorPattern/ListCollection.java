package com.wunderbar.BuildModel.IteratorPattern;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import java.util.List;

/**
 * @author Rommel
 * @date 2020/3/15 21:14
 * @description 集合的具体实现
 */

@Slf4j
public class ListCollection implements Collection {

    //数据存储容器
    List list = new ArrayList();

    public Iterator iterator() {
        return new ConcreteIterator(this);
    }

    public Object get(int i) {
        return list.get(i);
    }

    public boolean add(Object o) {
        list.add(o);
        return true;
    }

    public int size() {
        return list.size();
    }
}
