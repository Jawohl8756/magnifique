package com.wunderbar.BuildModel.ProxyPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 18:21
 * @description 代理模式示例
 */
@Slf4j
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Company company=new Proxy();//创建代理类对象，其实就是创建HR对象
        company.findWork("golang");//hr对象找工作，工作的名称告诉了，是“golang”
    }
}
