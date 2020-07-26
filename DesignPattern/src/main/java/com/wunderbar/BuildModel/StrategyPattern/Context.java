package com.wunderbar.BuildModel.StrategyPattern;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 21:30
 * @description  装在策略的容器，锦囊，妙计
 */
@Slf4j
@Setter
@Getter
public class Context {
    private TravelStrategy travelStrategy;


    //出行方式还是调用引用对象travelStrategy的出行方式
    public void travelMode(){
        this.travelStrategy.travelMode();
    }
}
