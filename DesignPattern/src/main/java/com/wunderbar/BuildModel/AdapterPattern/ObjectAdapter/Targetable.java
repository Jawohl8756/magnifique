package com.wunderbar.BuildModel.AdapterPattern.ObjectAdapter;


/**
 * @author Rommel
 * @date 2020/3/14 16:38
 * @description 目标类接口，需要具有两种功能
 * 1.编辑本文
 * 2.编辑word
 */
public interface Targetable {
    //编辑文本
    void editTextFile();

    //编辑word
    void editWordFile();
}
