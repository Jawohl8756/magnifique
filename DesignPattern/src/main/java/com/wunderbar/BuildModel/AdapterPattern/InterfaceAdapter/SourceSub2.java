package com.wunderbar.BuildModel.AdapterPattern.InterfaceAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 17:15
 * @description 子类2通过继承抽象类，实现另一个方法
 */
@Slf4j
public class SourceSub2 extends AbstractAdapter {
    @Override
    public void editWordFile() {
        log.info("a word file editor");
    }
}
