package com.wunderbar.BuildModel.ProxyPattern;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rommel
 * @date 2020/3/14 18:10
 * @description 代理对象类
 */
@Slf4j
public class Proxy implements Company {

    //代理类准备代理的真实对象-HR (HR 想要招聘一个Java工程师，但是今天要开会走不开，需要代理类帮助完成这项工作)
    private HR hr;

    //代理类的构造器实现里面就是new HR()，也就是说创建代理类对象，就是创建HR对象
    public Proxy() {
        super();
        this.hr = new HR();

    }

    //需要代理的方法
    @Override
    public void findWork(String title) {
        hr.findWork(title);
        String worker = getWorker(title);
        log.info("find a worker by proxy ,worker name is:" + worker);
    }

    public String getWorker(String tilte) {
        Map<String, String> workerList = new HashMap<String, String>() {
            {
                put("Java", "zhangsan");
                put("Python", "lisi");
                put("PHP", "wangwu");
                put("golang", "heqi");
            }
        };


        return workerList.get(tilte);

    }
}
