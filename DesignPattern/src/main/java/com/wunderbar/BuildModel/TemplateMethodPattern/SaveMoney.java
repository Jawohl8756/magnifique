package com.wunderbar.BuildModel.TemplateMethodPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/15 20:19
 * @description 存钱也是抽象模板的子类
 * 去银行存钱也需要
 * 1.叫号
 * 2.排队
 * 3.办业务（存钱）
 * 4.服务评价
 */

@Slf4j
public class SaveMoney extends AbstractTemplate {
    @Override
    public void handleBusiness() {
        log.info("save money to bank ...");
    }
}
