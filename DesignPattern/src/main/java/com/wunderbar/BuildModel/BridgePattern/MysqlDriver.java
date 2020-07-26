package com.wunderbar.BuildModel.BridgePattern;

import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

/**
 * @author Rommel
 * @date 2020/3/14 20:21
 * @description Mysql实现驱动接口
 */
@Slf4j
public class MysqlDriver implements Driver {
    @Override
    public void executeSQL() {
        log.info("execute sql by mysql driver...");

    }
}
