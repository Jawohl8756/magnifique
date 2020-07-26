package com.wunderbar.BuildModel.FactoryPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/16 19:40
 * @description 工厂模式代码
 */
@Slf4j
public class FactoryPatternDemo {

    public static void main(String[] args) {
        PhoneFactory factory=new PhoneFactory();
        Phone Huawei =factory.createPhone("Huawei");
        Phone iphone =factory.createPhone("Iphone");

        log.info(Huawei.brand());
        log.info(iphone.brand());


    }
}
