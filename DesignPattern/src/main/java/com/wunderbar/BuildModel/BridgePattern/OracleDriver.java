package com.wunderbar.BuildModel.BridgePattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 20:23
 * @description
 */
@Slf4j
public class OracleDriver implements Driver
{
    @Override
    public void executeSQL() {
        log.info("execute sql by oracle driver...");
    }
}
