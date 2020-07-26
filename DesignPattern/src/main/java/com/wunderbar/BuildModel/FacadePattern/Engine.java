package com.wunderbar.BuildModel.FacadePattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 20:02
 * @description 汽车子系统-引擎
 */
@Slf4j
public class Engine {
    public void startup(){
        log.info("engine startup...");
    }

    public void shutdown(){
        log.info("engine shutdown...");
    }
}
