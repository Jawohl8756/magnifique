package com.wunderbar.BuildModel.ChainOfResponsibilityPattern;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/15 22:06
 * @description 验证处理
 */
@Slf4j
@Setter
@Getter
public class AuthHandler extends AbstractHandler implements Handler {

    private String name ;

    public AuthHandler(String name){
        this.name =name ;
    }

    public void operate() {
        log.info("start to auth...");
        if(getHandler()!=null){
            getHandler().operate();

        }

    }
}
