package com.wunderbar.BuildModel.FlyweightPattern;

/**
 * @author Rommel
 * @date 2020/3/14 21:17
 * @description 享元模式示例
 */
public class FlyweightPatternDemo {

    public static void main(String[] args) {
        //首次获取内存，创建一个内存大小为32MB的内存
        Memory memory=MemoryFactory.getMemory(32);
        MemoryFactory.releaseMemory(memory.getId());

        MemoryFactory.getMemory(32);

    }
}
