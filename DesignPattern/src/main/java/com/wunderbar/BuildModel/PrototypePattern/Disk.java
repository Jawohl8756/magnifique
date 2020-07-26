package com.wunderbar.BuildModel.PrototypePattern;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Rommel
 * @date 2020/3/14 13:13
 * @description
 */
@Data
@AllArgsConstructor
public class Disk implements Cloneable {

    private String ssd ;//固态硬盘

    private String hhd ;//机械硬盘

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            return (Disk)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
