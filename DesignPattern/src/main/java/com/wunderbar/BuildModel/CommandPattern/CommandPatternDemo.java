package com.wunderbar.BuildModel.CommandPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/16 12:02
 * @description 命令模式示例
 */

@Slf4j
public class CommandPatternDemo {

    public static void main(String[] args) {
        Receiver receiver=new Receiver();

        Command cmd =new ConcreteCommand(receiver);

        Invoker invoker=new Invoker(cmd);

        invoker.action("command1 begin....");
    }
}
