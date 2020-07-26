package com.wunderbar.BuildModel.AbstractFactoryPattern;

import com.wunderbar.BuildModel.CommandPattern.Command;

/**
 * @author Rommel
 * @date 2020/3/16 19:53
 * @description
 */
public class MacBook implements Computer {
    public String internet() {
        return "surf the internet by the apple book";
    }
}
