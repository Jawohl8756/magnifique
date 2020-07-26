package com.wunderbar.BuildModel.MementoPattern;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rommel
 * @date 2020/3/16 12:32
 * @description 备忘录管理者
 * 储存备忘录
 * 仓库Storage拿到备忘录Memento,然后状态回退
 */

@Setter
@Getter
public class Storage {

    //仓库里面的备忘录
    private Memento memento ;

    //构造函数
    public Storage(Memento memento) {
        this.memento = memento;
    }
}
