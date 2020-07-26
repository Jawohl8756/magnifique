package com.wunderbar.BuildModel.FlyweightPattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Rommel
 * @date 2020/3/14 20:50
 * @description
 */
@Setter
@Getter
@AllArgsConstructor
public class Memory {

    private int size;//内存大小，大小MB

    private boolean issued ;//内存是否在被使用

    private String id ;//内存id





}
