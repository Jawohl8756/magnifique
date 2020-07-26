package com.wunderbar.BuildModel.TemplateMethodPattern;

/**
 * @author Rommel
 * @date 2020/3/15 20:23
 * @description 模板方法模式的实例
 *
 * 模板方法模式，类似活字印刷术
 * 声明抽象类和抽象模板方法，抽象方法中声明流程的各个方法
 *
 * 子类继承抽象类，并调用模板方法，就可以实现整个业务员流程
 */
public class TemplateMethodPatternDemo {

    public static void main(String[] args) {
        //模拟取钱流程
        AbstractTemplate template1=new TakeMoney();
        template1.templateMethod();

        //模拟存钱流程
        AbstractTemplate template2 =new SaveMoney();
        template2.templateMethod();
    }
}
