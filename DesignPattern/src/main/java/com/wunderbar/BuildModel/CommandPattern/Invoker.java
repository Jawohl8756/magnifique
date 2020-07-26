package com.wunderbar.BuildModel.CommandPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/16 12:00
 * @description 命令发布者
 */

@Slf4j
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(String commandMessage){
        log.info("command sending");

        command.execute(commandMessage);

    }
}
