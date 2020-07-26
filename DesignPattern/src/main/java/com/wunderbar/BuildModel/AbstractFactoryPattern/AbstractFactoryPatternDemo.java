package com.wunderbar.BuildModel.AbstractFactoryPattern;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.impl.Log4jLoggerAdapter;

/**
 * @author Rommel
 * @date 2020/3/16 20:09
 * @description
 */

@Slf4j
public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {
        AbstractFactory phoneFactory = new PhoneFactory();

        Phone xiaomi = phoneFactory.createPhone("Xiaomi");
        Phone apple = phoneFactory.createPhone("apple");

        log.info(xiaomi.call());
        log.info(apple.call());

        AbstractFactory computerFactory = new ComputerFactory();

        Computer huaweiBook = computerFactory.createComputer("huawei");
        Computer macbook = computerFactory.createComputer("macbook");

        log.info(huaweiBook.internet());
        log.info(macbook.internet());


    }


}
