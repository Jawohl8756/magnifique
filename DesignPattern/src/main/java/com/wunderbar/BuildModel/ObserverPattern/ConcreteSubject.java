package com.wunderbar.BuildModel.ObserverPattern;

import com.wunderbar.BuildModel.AdapterPattern.ObjectAdapter.ObjectAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/15 20:35
 * @description 具体的目标类，被观察的类
 */

@Slf4j
public class ConcreteSubject extends Subject {


    public void notifyObserver(String message) {
        for (Object obs :observers){
            log.info("notify observer message:"+message+"change ....");
            ((Observer)obs).dataChange(message);
        }
    }
}
