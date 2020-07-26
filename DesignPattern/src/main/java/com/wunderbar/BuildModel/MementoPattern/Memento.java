package com.wunderbar.BuildModel.MementoPattern;

import com.wunderbar.BuildModel.FlyweightPattern.Memory;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Rommel
 * @date 2020/3/16 12:29
 * @description
 */

@Setter
@Getter
public class Memento {
    //备忘录是基础类的copy副本，储存和回退用的
    private String value ;//字段value和基类一样

    //构造函数，参数是基类的值
    public Memento(String value){
        this.value=value;

    }
}
