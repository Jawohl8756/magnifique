package com.wunderbar.BuildModel.CompositePattern;

import lombok.Getter;
import lombok.Setter;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author Rommel
 * @date 2020/3/14 20:36
 * @description 树节点
 */
@Setter
@Getter
public class TreeNode {

    private String name ;

    private TreeNode parent ;

    public TreeNode(String name){
        this.name=name;
    }

    //放置节点的容器
    private Vector<TreeNode> children =new Vector<TreeNode>();

    //添加子节点
    public void add(TreeNode node){
        children.add(node);
    }
    //删除子节点
    public void delete(TreeNode node){
        children.remove(node);
    }
    //获取子节点
    public Enumeration<TreeNode> getChildren(){
        return children.elements() ;
    }



}
