package com.wunderbar.BuildModel.StatePattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/16 13:13
 * @description  工作状态
 */

@Slf4j
public class WorkState extends AbstractState {
    public void action(Context context) {
        log.info("state change to work state");
        log.info("work state actions are meeting ,designing and coding TV");
    }
}
