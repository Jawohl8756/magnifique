package com.wunderbar.BuildModel.AbstractFactoryPattern;

import com.wunderbar.BuildModel.AbstractFactoryPattern.Computer;


/**
 * @author Rommel
 * @date 2020/3/16 19:47
 * @description
 */
public class PhoneFactory extends AbstractFactory {
    public Phone createPhone(String brand) {
        if ("Xiaomi".equals(brand)) {
            return new XiaomiPhone();

        } else if ("apple".equals(brand)) {
            return new ApplePhone();

        } else {
            return null;
        }
    }

    public Computer createComputer(String brand) {
        return null;
    }


}
