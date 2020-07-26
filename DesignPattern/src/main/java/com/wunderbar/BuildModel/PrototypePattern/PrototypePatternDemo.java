package com.wunderbar.BuildModel.PrototypePattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 13:20
 * @description 原型模式示例
 */
@Slf4j
public class PrototypePatternDemo {

    public static void main(String[] args) {
        /**
         * 1.浅复制
         * */
        ComputerSimple computerSimple = new ComputerSimple("I9", "16G", "128SSD");
        log.info("before the simple clone:" + computerSimple.toString());

        try {
            ComputerSimple computerSimpleClone = (ComputerSimple) computerSimple.clone();

            log.info("after the simple clone:" + computerSimpleClone.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            log.info("浅克隆失败:" + e.getMessage());
        }


        /**
         * 2.深复制
         *   引用对象Disk改变，克隆后也改变,更新到最新
         *
         * */
        Disk disk = new Disk("128G", "1TB");
        ComputerDeep computerDeep = new ComputerDeep("I7", "8G", disk);
        log.info("before the deep clone :" + computerDeep.toString());


        try {
            //中途改变了引用对象Disk的属性，深复制以后，也会体现出来。
            computerDeep.setDisk(new Disk("512G", "500G"));
            ComputerDeep computerDeepClone = (ComputerDeep) computerDeep.clone();
            log.info("after the deep clone :" + computerDeepClone.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            log.info("深克隆失败:" + e.getMessage());
        }


    }
}
