package com.wunderbar.BuildModel.BridgePattern;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rommel
 * @date 2020/3/14 20:25
 * @description 抽象类：驱动管理桥接类
 */
@Setter
@Getter
public abstract class DriverManagerBridge {

    private Driver driver;//接口类型的驱动，注入什么就执行什么类型的数据库

    public void execute(){
        this.driver.executeSQL();
    }
}
