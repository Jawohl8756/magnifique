package com.wunderbar.BuildModel.MediatorPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/16 14:59
 * @description 房东
 */

@Slf4j
public class ColleagueLandlord extends Colleague  {
    @Override
    public boolean operation(String message) {

        log.info("Landlord received a message from Mediator:"+message);
        return true;
    }
}
