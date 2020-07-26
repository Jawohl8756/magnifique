package com.wunderbar.BuildModel.BridgePattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 20:31
 * @description 桥接模式demo
 */
@Slf4j
public class BridgePatternDemo {

    public static void main(String[] args) {

        DriverManagerBridge driverManagerBridge=new MyDriverBridge();

        //设置Mysql驱动
        driverManagerBridge.setDriver(new MysqlDriver());
        driverManagerBridge.execute();

        //多数据源，切换到Oracle
        driverManagerBridge.setDriver(new OracleDriver());
        driverManagerBridge.execute();

    }
}
