package com.wunderbar.BuildModel.FacadePattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 20:16
 * @description 外观模式实例
 */
@Slf4j
public class FacadePatternDemo {

    public static void main(String[] args) {
        FacadeStarter starter=new FacadeStarter();
        starter.startup();
        System.out.println("********************");
        starter.shutdown();
    }
}
