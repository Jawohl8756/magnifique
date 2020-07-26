package com.wunderbar.BuildModel.DecoratorPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 17:37
 * @description 装饰者模式示例
 */

@Slf4j
public class DecoratorPatternDemo {

    public static void main(String[] args) {
        Source source =new Source();
        Decorator decorator=new Decorator(source);
        decorator.productComputer();

    }
}
