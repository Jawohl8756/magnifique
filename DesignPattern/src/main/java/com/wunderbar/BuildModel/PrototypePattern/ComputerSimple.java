package com.wunderbar.BuildModel.PrototypePattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 13:03
 * @description 浅复制
 * 只复制基本数据类型
 * 引用数据类型，不会复制（Object）
 */
@Data
@AllArgsConstructor
@Slf4j
public class ComputerSimple implements Cloneable {
    private String cpu ;

    private String memory ;

    private String disk ;

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            return (ComputerSimple)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            log.info("克隆失败:"+e.getMessage());

            return null;
        }
    }
}
