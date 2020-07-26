package com.wunderbar.BuildModel.MementoPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/16 12:33
 * @description 备忘录模式demo
 */

@Slf4j
public class MementoPatternDemo {

    public static void main(String[] args) {

        //创建原始类，带有属性值“张三”
        Original original = new Original("zhangsan");

        //创建备忘录库，库里面有备忘录
        Storage storage = new Storage(original.createMemento());

        //修改原始类的状态
        log.info("original value :" + original.getValue());
        original.setValue("lisi");
        log.info("updated value:" + original.getValue());

        //恢复原始状态
        original.restoreMemento(storage.getMemento());
        log.info("restore value:" + original.getValue());
    }
}
