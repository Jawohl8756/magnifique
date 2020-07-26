package com.wunderbar.BuildModel.BuilderPattern;

/**
 * @author Rommel
 * @date 2020/3/14 12:03
 * @description 生产复杂对象Computer的导演类
 * <p>
 * 导演，一声令下      --顶级命令类
 * 监工拿到命令        -- 接口
 * 民工               --具体实现
 */
public class ComputerDirector {

    public Computer constructComputer(ComputerBuilder computerBuilder) {//参数传接口，不传具体实现类
        computerBuilder.buildCpu();
        computerBuilder.buildMemory();
        computerBuilder.buildDisk();


        return computerBuilder.buildComputer();

    }
}
