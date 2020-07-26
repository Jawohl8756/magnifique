package com.wunderbar.BuildModel.VisitorPattern;

/**
 * @author Rommel
 * @date 2020/3/16 13:24
 * @description
 */
public interface Element {

    void accept(Visitor visitor);
}
