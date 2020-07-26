package com.wunderbar.BuildModel.StrategyPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 21:29
 * @description 汽车出行策略
 */
@Slf4j
public class TravelByCarStrategy implements TravelStrategy {
    public void travelMode() {
        log.info("travel by car");
    }
}
