package com.wunderbar.BuildModel.ChainOfResponsibilityPattern;

import javax.swing.plaf.metal.OceanTheme;

/**
 * @author Rommel
 * @date 2020/3/16 11:45
 * @description 责任链模式示例
 */
public class ChainOfResponsibilityPatternDemo {

    public static void main(String[] args) {
        AuthHandler authHandler = new AuthHandler("auth");

        BusinessHandler businessHandler = new BusinessHandler("business");

        ResponseHandler responseHandler = new ResponseHandler("response");

        authHandler.setHandler(businessHandler);
        businessHandler.setHandler(responseHandler);
        authHandler.operate();
    }
}
