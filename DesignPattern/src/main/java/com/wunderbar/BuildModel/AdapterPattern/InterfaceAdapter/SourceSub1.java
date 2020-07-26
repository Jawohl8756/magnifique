package com.wunderbar.BuildModel.AdapterPattern.InterfaceAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 17:13
 * @description 子类一去继承拥有全部方法的抽象实现类
 * 单继承，多实现
 */
@Slf4j
public class SourceSub1 extends AbstractAdapter {
    @Override
    public void editTextFile() {
        log.info("a text file editor");
    }
}
