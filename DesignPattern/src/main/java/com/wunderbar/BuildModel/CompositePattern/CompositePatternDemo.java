package com.wunderbar.BuildModel.CompositePattern;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.objects.NativeJSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/14 20:42
 * @description 组合模式示例
 */
@Slf4j
public class CompositePatternDemo {
    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        nodeA.add(nodeB);
        log.info(JSON.toJSONString(nodeA));
    }
}
