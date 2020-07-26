package com.wunderbar.BuildModel.FacadePattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 20:06
 * @description 外观门面类
 *
 * 协调封装子系统Dashboard和Engine,暴露统一接口供SelfCheck的访问
 */

@Slf4j
public class FacadeStarter {
    private Dashboard dashboard;//子系统仪表盘

    private Engine engine;//子系统引擎

    private SelfCheck selfCheck;//业务入口，访问子系统

    //门面类构造器，就是子类的集合
    public FacadeStarter(){
        this.dashboard =new Dashboard();
        this.engine=new Engine();
        this.selfCheck =new SelfCheck();
    }

    public void startup(){
        log.info("car begin startup...");
        engine.startup();
        dashboard.startup();
        selfCheck.startupCheck();
        log.info("car startup finished...");
    }

    public void shutdown(){

        log.info("car begin shutdown...");
        engine.shutdown();
        dashboard.shutdown();
        selfCheck.shutdownCheck();
        log.info("car shutdown finished...");

    }

}
