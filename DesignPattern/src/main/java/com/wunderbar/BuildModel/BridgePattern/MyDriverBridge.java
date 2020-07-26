package com.wunderbar.BuildModel.BridgePattern;

/**
 * @author Rommel
 * @date 2020/3/14 20:28
 * @description
 */
public class MyDriverBridge extends DriverManagerBridge {

    public void execute(){
      getDriver().executeSQL();
    }
}
