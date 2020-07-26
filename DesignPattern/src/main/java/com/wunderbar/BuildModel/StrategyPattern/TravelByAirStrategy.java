package com.wunderbar.BuildModel.StrategyPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 21:28
 * @description 飞行出游模式
 */



@Slf4j
public class TravelByAirStrategy implements TravelStrategy {
    public void travelMode() {
        log.info("travel by air");
    }
}
