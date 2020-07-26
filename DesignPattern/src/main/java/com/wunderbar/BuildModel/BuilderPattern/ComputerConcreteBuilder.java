package com.wunderbar.BuildModel.BuilderPattern;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Rommel
 * @date 2020/3/14 11:03
 * @description ComputerBuilder接口的具体干活的实现类
 */
@Slf4j
public class ComputerConcreteBuilder implements ComputerBuilder {


    //声明要被创建的最终复杂对象
    public Computer computer;

    //通过无参构造器创建对象，并准备接下来的赋值
    public ComputerConcreteBuilder() {
        computer = new Computer();
        log.info("构造器内声明复杂对象Computer...");
    }

    /**
     * 构建cpu对象
     */
    public void buildCpu() {
        log.info("buildCpu.....");
        computer.setCpu("8core");
    }

    /**
     * 构建内存对象
     */
    public void buildMemory() {
        log.info("buildMemory....");
        computer.setMemory("16G");

    }

    /**
     * 构建硬盘对象
     */
    public void buildDisk() {
        log.info("buildDisk....");
        computer.setDisk("256G-SSD");

    }

    /**
     * 以上小对象都构建完成
     * 构建复杂大对象Computer
     */
    public Computer buildComputer() {
        return computer;
    }
}
