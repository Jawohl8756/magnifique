package com.wunderbar.BuildModel.CommandPattern;

/**
 * @author Rommel
 * @date 2020/3/16 11:54
 * @description 实际命令
 */
public class ConcreteCommand implements Command {

    private Receiver receiver ;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }



    public void execute(String command) {
        receiver.action(command);
    }
}
