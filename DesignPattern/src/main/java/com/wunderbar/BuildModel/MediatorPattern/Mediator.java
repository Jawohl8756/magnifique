package com.wunderbar.BuildModel.MediatorPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/16 15:24
 * @description 中介类
 */

@Slf4j
public abstract class Mediator {

    protected Colleague colleagueLandlord ;

    protected Colleague colleagueTenant;

    public Mediator(Colleague colleagueTenant,Colleague colleagueLandlord) {
        this.colleagueTenant=colleagueTenant;
        this.colleagueLandlord = colleagueLandlord;

    }

    public abstract boolean notifyColleagueTenant(String message);
    public abstract boolean notifyColleagueLandlord(String message);

}
