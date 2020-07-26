package com.wunderbar.BuildModel.AdapterPattern.ObjectAdapter;

import com.wunderbar.BuildModel.AdapterPattern.ObjectAdapter.Source;
import com.wunderbar.BuildModel.AdapterPattern.ObjectAdapter.Targetable;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 16:52
 * @description 对象适配器实现目标接口，不在继承源类
 * 但是可以直接注入源类,并且通过对象适配器的构造函数传入
 */
@Slf4j
public class ObjectAdapter implements Targetable {

    //对象级别不被实现，但是引用对象注入，并构造器传入
    private Source source;

    public ObjectAdapter(Source source) {
        super();
        this.source = source;

    }

    @Override
    public void editTextFile() {
        this.source.editTextFile();
        log.info("this method comes from Source.java");
    }

    @Override
    public void editWordFile() {
        log.info("a word file editor");
    }
}
