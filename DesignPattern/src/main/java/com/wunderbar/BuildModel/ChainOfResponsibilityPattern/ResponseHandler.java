package com.wunderbar.BuildModel.ChainOfResponsibilityPattern;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

/**
 * @author Rommel
 * @date 2020/3/16 11:42
 * @description
 */

@Slf4j
@Setter
@Getter
public class ResponseHandler extends AbstractHandler implements Handler {

    private String name ;

    public ResponseHandler(String name) {
        this.name = name;
    }

    public void operate() {
        log.info("message response...");
        if (getHandler()!=null){
            getHandler().operate();

        }
    }
}
