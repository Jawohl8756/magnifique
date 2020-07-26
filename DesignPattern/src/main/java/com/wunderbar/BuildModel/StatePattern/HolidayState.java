package com.wunderbar.BuildModel.StatePattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/16 13:15
 * @description  假期状态
 */
@Slf4j
public class HolidayState extends AbstractState {
    public void action(Context context) {

        log.info("state change to holiday state");

        log.info("holiday state actions are travel ,shopping ,watching TV ");

    }
}
