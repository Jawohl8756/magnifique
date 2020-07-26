package com.wunderbar.BuildModel.DecoratorPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 17:29
 * @description 真实对象Source 实现 Sourceable接口，能够生产电脑
 */

@Slf4j
public class Source implements Sourceable {
    @Override
    public void productComputer() {
        log.info("product computer by Source");

    }
}
