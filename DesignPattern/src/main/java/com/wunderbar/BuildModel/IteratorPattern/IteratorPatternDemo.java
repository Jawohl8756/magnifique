package com.wunderbar.BuildModel.IteratorPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/15 21:53
 * @description 迭代器模式实现
 */

@Slf4j
public class IteratorPatternDemo {

    public static void main(String[] args) {
        Collection collection = new ListCollection();

        collection.add("object1");

        Iterator iterator = collection.iterator();

        while (iterator.hasNext()) {
            log.info("ss:" + iterator.next());
        }
    }
}
