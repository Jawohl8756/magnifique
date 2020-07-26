package com.wunderbar.BuildModel.AdapterPattern.ClassAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 16:40
 * @description 适配器应用类
 */
@Slf4j
public class Adapter extends Source implements Targetable {
    @Override
    public void editWordFile() {

        log.info("a word file editor");

    }
}
