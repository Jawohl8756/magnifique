package com.wunderbar.BuildModel.AdapterPattern.ObjectAdapter;

/**
 * @author Rommel
 * @date 2020/3/14 16:59
 * @description 对象适配器示例
 */
public class ObjectAdapterDemo {

    public static void main(String[] args) {
       Source source =new Source();
       Targetable adapter = new ObjectAdapter(source);
       adapter.editTextFile();
       adapter.editWordFile();
    }
}
