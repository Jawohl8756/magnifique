package com.wunderbar.BuildModel.VisitorPattern;

/**
 * @author Rommel
 * @date 2020/3/16 13:22
 * @description 访问者接口
 */
public interface Visitor {
    
    
    void visit(ProjectElement element);

}
