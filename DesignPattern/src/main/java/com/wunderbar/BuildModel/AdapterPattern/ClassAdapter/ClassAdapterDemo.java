package com.wunderbar.BuildModel.AdapterPattern.ClassAdapter;

/**
 * @author Rommel
 * @date 2020/3/14 16:44
 * @description 类适配器示例
 *
 * 源类有一个方法1，还想实现目标借口的方法2
 * 新建一个适配器类：1.作为源类的子类，进行继承，这个适配器类拥有了源类的方法（子类有父类的清一切，还能继续扩展）
 *                 2.实现目标接口，具有接口的方法了。
 *                 这样，在目标类和接口不方便耦合的情况下，派生出来的适配器类作为源类的子类和目标接口的实现类。
 *                 左手托着花（继承），右手指着月（实现）
 */
public class ClassAdapterDemo {

    public static void main(String[] args) {
        Targetable adapter =new Adapter();
        adapter.editTextFile();
        adapter.editWordFile();
    }
}
