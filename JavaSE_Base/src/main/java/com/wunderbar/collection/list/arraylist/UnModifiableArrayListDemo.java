package com.wunderbar.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Rommel
 * @date 2021/1/4 15:20
 * @description Java中成员变量和方法的访问权限，一直是个安全问题
 * private protected public
 * 确保父类是Collection接口的子类类型变量是<只读的>Only Readable</只读的>
 * @see java.util.Collections#unmodifiableList(List)
 *
 */
public class UnModifiableArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("er");
        strings.add("ist");
        strings.add("da");
        System.out.println("Original strings=" + strings);

        /**
         * ArrayList#set()方法具有变更属性的能力，能使值改变，不安全。
         * 如果我们不想set()方法执行呢？
         *
         * 比如一个User.phone[]属性，是个List，如果被查询到，并update，再save
         * 恶意篡改，那就是数据不安全了。
         * 需要使用:
         * Collections.unmodifiableList(List list);
         * */
        strings.set(0, "sie");
        System.out.println("After update string=" + strings);

        /**
         * 使用Collections工具类安全处理一下List的子类，获取的对象，
         * 再想变更操作，就会报错：
         * UnsupportedOperationException
         *
         * 既然List能进行#unmodifiableXXX()操作
         * Set Map等，Collections也是提供了类似的方法.
         * */
        List<String> list = Collections.unmodifiableList(strings);
        list.set(1, "sind");
        System.out.println("update this string with bad purpose:" + strings);


    }
}
