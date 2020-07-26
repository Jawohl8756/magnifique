package com.wunderbar.BuildModel.AdapterPattern.InterfaceAdapter;

/**
 * @author Rommel
 * @date 2020/3/14 17:11
 * @description 不想实现接口Sourceable接口中的所有方法
 * 声明一个抽象适配器，实现这个接口
 *
 */
public abstract class AbstractAdapter implements Sourceable {

    @Override
    public void editTextFile() {

    }

    @Override
    public void editWordFile() {

    }
}
