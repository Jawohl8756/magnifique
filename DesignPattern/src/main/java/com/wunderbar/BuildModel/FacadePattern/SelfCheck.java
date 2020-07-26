package com.wunderbar.BuildModel.FacadePattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 20:03
 * @description 自检业务类，要分别访问各个子系统：
 * 仪表盘
 * 引擎
 */
@Slf4j
public class SelfCheck {
    public void startupCheck() {
        log.info("startup check has finished...");
    }

    public void shutdownCheck() {
        log.info("shutdown check has finished...");
    }


}
