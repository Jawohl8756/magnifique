package com.wunderbar.BuildModel.AbstractFactoryPattern;

import com.wunderbar.BuildModel.AbstractFactoryPattern.Computer;

/**
 * @author Rommel
 * @date 2020/3/16 19:55
 * @description
 */
public class ComputerFactory extends AbstractFactory {
    public Phone createPhone(String brand) {
        return null;
    }

    public Computer createComputer(String brand) {

        if("huawei".equals(brand)){
            return new HuaweiBook();
        }
        else if("macbook".equals(brand)){
            return new MacBook();

        }else {
            return null;
        }
    }
}
