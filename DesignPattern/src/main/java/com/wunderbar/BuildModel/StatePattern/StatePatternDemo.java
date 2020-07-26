package com.wunderbar.BuildModel.StatePattern;

/**
 * @author Rommel
 * @date 2020/3/16 13:19
 * @description 状态模式的代码
 */
public class StatePatternDemo {

    public static void main(String[] args) {
        //定义当前的状态为工作状态
        Context context=new Context(new WorkState());
        context.action();//执行

        //切换状态为假期状态
        context.setState(new HolidayState());
        context.action();//执行
    }
}
