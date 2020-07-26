package com.wunderbar.BuildModel.StrategyPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 21:32
 * @description 策略模式的实例
 */
@Slf4j
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context =new Context();
        TravelStrategy travelByAirStrategy=new TravelByAirStrategy();
        context.setTravelStrategy(travelByAirStrategy);
        context.travelMode();
        log.info("change travel strategy to travel by car strategy....");

        //设置出行策略为汽车出行
        TravelStrategy travelByCarStrategy=new TravelByCarStrategy();
        context.setTravelStrategy(travelByCarStrategy);
        context.travelMode();

    }
}
