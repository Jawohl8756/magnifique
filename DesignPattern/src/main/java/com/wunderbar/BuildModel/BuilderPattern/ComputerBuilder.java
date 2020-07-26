package com.wunderbar.BuildModel.BuilderPattern;



/**
 * @author Rommel
 * @date 2020/3/14 10:58
 * @description 能够组件Computer复杂对象的接口类
 */
public interface ComputerBuilder {

    void buildCpu();//构建cpu对象

    void buildMemory();//构建内存对象

    void buildDisk();//构建硬盘对象

    Computer buildComputer();//三个都完成，构建复杂Computer对象

}
