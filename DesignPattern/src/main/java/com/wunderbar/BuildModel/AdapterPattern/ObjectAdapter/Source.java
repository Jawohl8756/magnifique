package com.wunderbar.BuildModel.AdapterPattern.ObjectAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 16:36
 * @description 源类，无法直接和目标类对接，需要适配器
 */
@Slf4j
public class Source {

    //只能编辑文本文件
    public void editTextFile(){
        log.info("a text file editor");
    }


}
