package com.wunderbar.BuildModel.CommandPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/16 11:55
 * @description 命令接收者
 */

@Slf4j
public class Receiver {

    public void action(String command){
log.info("Command received , now execute the command....");

    }

}
