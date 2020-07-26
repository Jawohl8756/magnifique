package com.wunderbar.BuildModel.ProxyPattern;


import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 18:01
 * @description 人力也招人，是公司招人的具体实现，干这项工作的人
 */ 

@Slf4j
public class HR implements Company {

    public void findWork(String title) {
        log.info("i need a worker ,title is:"+title);

    }
}
