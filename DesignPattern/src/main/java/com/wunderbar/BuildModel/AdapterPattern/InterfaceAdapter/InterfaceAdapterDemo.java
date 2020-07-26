package com.wunderbar.BuildModel.AdapterPattern.InterfaceAdapter;

/**
 * @author Rommel
 * @date 2020/3/14 17:17
 * @description 接口适配器示例
 */
public class InterfaceAdapterDemo {

    public static void main(String[] args) {
        Sourceable s1 =new SourceSub1();
        Sourceable s2 =new SourceSub2();

        s1.editTextFile();
        s2.editWordFile();
    }
}
