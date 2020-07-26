package com.wunderbar.BuildModel.ChainOfResponsibilityPattern;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

/**
 * @author Rommel
 * @date 2020/3/16 11:40
 * @description
 */
@Slf4j
@Setter
@Getter
public class BusinessHandler extends AbstractHandler implements Handler {

    private String name ;

    public BusinessHandler(String name) {
        this.name = name;
    }

    public void operate() {
       log.info("business info handler");
       if(getHandler()!=null){
           getHandler().operate();

       }
    }
}
