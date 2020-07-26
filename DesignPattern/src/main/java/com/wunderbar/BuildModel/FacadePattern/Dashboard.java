package com.wunderbar.BuildModel.FacadePattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 20:00
 * @description 汽车子系统-仪表盘
 *
 */
@Slf4j
public class Dashboard {
    public void startup(){
        log.info("dashboard startup...");
    }

    public void shutdown(){
        log.info("dashboard shutdown...");
    }

}
