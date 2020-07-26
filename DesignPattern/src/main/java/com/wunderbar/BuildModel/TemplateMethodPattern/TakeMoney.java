package com.wunderbar.BuildModel.TemplateMethodPattern;


import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/15 20:21
 * @description 取钱
 */
@Slf4j
public class TakeMoney extends AbstractTemplate {

    @Override
    public void handleBusiness() {
        log.info("take money from bank .....");
    }
}
