package com.wunderbar.BuildModel.MementoPattern;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rommel
 * @date 2020/3/16 12:28
 * @description 要备份的基础类，将来属性会变更获取，或者获取变更之后再回退获取之前的状态
 */

@Setter
@Getter
public class Original {
    //基类的属性：值 ，需要变化和回退状态的变量
    //和备忘录里面的属性：值，是同一个
    private String value ;

    //构造函数，带有值属性
    public Original(String value) {
        this.value = value;
    }

    //基类创建《备忘录》，这个基类创建副本为了状态更新后的回退。
    public Memento createMemento(){
        return new Memento(value);//备忘录副本里面的字段value和基类的value 一样
    }

    //重置备忘录
    public void restoreMemento(Memento memento){
        this.value=memento.getValue();//备忘录里面的值拿回来赋予本基类，就是回退

    }
}
