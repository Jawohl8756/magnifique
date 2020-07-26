package com.wunderbar.BuildModel.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rommel
 * @date 2020/3/15 20:29
 * @description 抽象主题
 * 抽象目标类,这个类是被观察的对象，一旦本类有任何变化，通知观察者
 */
public abstract class Subject {

    protected List<Observer> observers =new ArrayList<Observer>();

    //增加观察者
    public void add(Observer observer){
        observers.add(observer);
    }

    //删除观察者
    public void delete(Observer observer){
        observers.remove(observer);
    }

    //通知观察者的抽象方法，不带方法体，就是类似接口，用于实现的
    public abstract void notifyObserver(String message);

}
