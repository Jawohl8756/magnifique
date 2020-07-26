package com.wunderbar.BuildModel.AbstractFactoryPattern;

import com.wunderbar.BuildModel.AbstractFactoryPattern.Computer;

/**
 * @author Rommel
 * @date 2020/3/16 19:49
 * @description 抽象工厂
 */
public abstract class AbstractFactory {

    public abstract Phone createPhone(String brand);

    public abstract Computer createComputer(String brand);
}
