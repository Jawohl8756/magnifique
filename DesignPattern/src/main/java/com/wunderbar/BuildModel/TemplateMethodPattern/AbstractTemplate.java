package com.wunderbar.BuildModel.TemplateMethodPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/15 20:12
 * @description 抽象模板类
 */

@Slf4j
public abstract class AbstractTemplate {

    public void templateMethod() {

        checkNumber();//抽号
        queueUp();//排队
        handleBusiness();//办业务
        serviceEvaluation();//服务评价


    }

    public void checkNumber() {
        log.info("check number...");
    }

    public void queueUp() {
        log.info("queue up...");
    }

    public void handleBusiness() {
        log.info("handle the business....");
    }

    public void serviceEvaluation() {
        log.info("business finished,evaluate the service..");
    }


}
