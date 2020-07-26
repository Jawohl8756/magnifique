package com.wunderbar.BuildModel.ObserverPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/15 20:42
 * @description 具体观察者
 */

@Slf4j
public class ConcreteObserver implements Observer {
    public void dataChange(String message) {

        log.info("receive message:"+message);

    }
}
