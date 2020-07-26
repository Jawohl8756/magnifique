package com.wunderbar.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Rommel
 * @date 2020/7/18 21:02
 * @description TreeSet 能够
 * 1.自然排序ASC
 * 2.定制排序 ：实现Java比较器Comparator接口
 */

public class TreeSetDemo {


    @Test
    public void treeSetTest() {

        TreeSet set = new TreeSet();

        /**
         * 失败案例
         * 不指定泛型，不同类型元素，不能加到一个容器
         * Exception in thread "main" java.lang.ClassCastException:
         * java.lang.String cannot be cast to java.lang.Integer
         * */
        //set.add("Rommel");
        //set.add(88);
        //set.add(new User("Jim",22));

        /**
         * 1.自然排序
         * 同一类型元素，自然排序，升序ASC
         * */
        //set.add(-12);
        //set.add(12);
        //set.add(234);
        //set.add(23);
        //set.add(56);

        /**
         * 2.定制排序:需要对象指定排序的Key
         * Exception in thread "main" java.lang.ClassCastException:
         * com.wunderbar.collection.User cannot be cast to java.lang.Comparable
         *
         * */
        set.add(new User("Mike", 23));
        set.add(new User("Jordan", 56));
        set.add(new User("Tim", 38));
        set.add(new User("Tatum", 21));
        set.add(new User("Youngth", 22));
        set.add(new User("Doncic", 19));



        /**
         * Set的遍历方式，由于无顺，不重复，没有下角标，没有连续的下角标
         * 不能用for遍历，只能用Iterator接口
         * */
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
