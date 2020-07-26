package com.wunderbar.BuildModel.DecoratorPattern;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import sun.rmi.runtime.Log;

/**
 * @author Rommel
 * @date 2020/3/14 17:31
 * @description 装饰者
 */
@Slf4j
public class Decorator implements Sourceable {
    //注入真实对象Source，准备进行装饰
    private Sourceable source;

    //构造器注入 ，狸猫换太子，爱你就是爱自己，new 的是Decorator，其实new的是真实对象Source
    public Decorator(Source source) {
        super();
        this.source = source;

    }


    @Override
    public void productComputer() {
        //装饰者生产完电脑
        source.productComputer();

        //装饰者做系统
        log.info("make system");


    }
}
