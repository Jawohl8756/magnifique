package com.wunderbar.BuildModel.ObserverPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/15 20:46
 * @description 观察者模式demo
 */
@Slf4j
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject=new ConcreteSubject();
        Observer observer =new ConcreteObserver();
        subject.add(observer);
        subject.notifyObserver("the wolf is coming....");


    }
}
