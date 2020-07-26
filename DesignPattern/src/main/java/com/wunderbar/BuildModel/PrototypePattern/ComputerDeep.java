package com.wunderbar.BuildModel.PrototypePattern;

import com.wunderbar.BuildModel.BuilderPattern.ComputerDirector;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Rommel
 * @date 2020/3/14 13:09
 * @description 深复制
 */
@Data
@AllArgsConstructor
public class ComputerDeep implements Cloneable {

    private String cpu;

    private String memory;

    private Disk disk;//深拷贝中的引用变量（对象）


    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            ComputerDeep computerDeep = (ComputerDeep) super.clone();
            computerDeep.disk = (Disk) this.disk.clone();


            return computerDeep;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }


}


