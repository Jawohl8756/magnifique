package com.wunderbar.BuildModel.MediatorPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/16 15:02
 * @description 租户
 */

@Slf4j
public class ColleagueTenant extends Colleague {
    public boolean operation(String message) {
        log.info("tenant received a message from mediator:"+message);


        return true;
    }
}
