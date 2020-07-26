package com.wunderbar.BuildModel.FactoryPattern;

/**
 * @author Rommel
 * @date 2020/3/16 19:37
 * @description 手机工厂
 * 根据传入的参数，决定事务
 */
public class PhoneFactory {

    public Phone createPhone(String phoneName) {

        if ("Huawei".equals(phoneName)) {
            return new Huawei();
        } else if ("Iphone".equalsIgnoreCase(phoneName)) {
            return new Iphone();

        } else {
            return null;
        }

    }
}
