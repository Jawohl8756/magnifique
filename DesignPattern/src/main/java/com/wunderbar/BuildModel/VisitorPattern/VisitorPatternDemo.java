package com.wunderbar.BuildModel.VisitorPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/16 14:06
 * @description
 */

@Slf4j
public class VisitorPatternDemo {

    public static void main(String[] args) {

        //声明一个项目对象，
        Element element = new ProjectElement("mo bike", "share bicycle");

        //项目接受访客、的到来
        element.accept(new CEOVisitor());
        element.accept(new CTOVisitor());
    }
}
