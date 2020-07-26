package com.wunderbar.BuildModel.BuilderPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 12:09
 * @description 构建者模式 案例
 */
@Slf4j
public class BuilderPatternDemo {

    public static void main(String[] args) {

        //1.声明一个大经理对象，准备发布命令给监工
        ComputerDirector computerDirector = new ComputerDirector();

        //2.声明一个监工接口，不具体实施项目，但是会找具体实现类实现
        ComputerBuilder computerBuilder = new ComputerConcreteBuilder();

        //3.大经理命令开始构建开工，命令发给监工，监工后台自然会调用具体实现类农名工去实现小对象到大对象的整体流程装配
        //大经理见不到农民工，1-3两者不耦合
        Computer computer = computerDirector.constructComputer(computerBuilder);

        log.info(computer.getCpu());
        log.info(computer.getMemory());
        log.info(computer.getDisk());
    }
}
