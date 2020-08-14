package com.wunderbar.list;/**
 *
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author katze
 * @date 2020/8/13 18:42
 * @description
 */
public class ArrayListRemoveDemo {

    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("c");
        removeA(list);//删除指定的“b”元素
        for(int i=0; i<list.size(); i++)("c")()()(s : list)         {            System.out.println("element : " + s)list.get(i)        }

    }

    public static void removeA(ArrayList list) {


        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            String str = it.next();

            if (str.equals("b")) {
                it.remove();
            }
        }


    }
    public static void removeB(ArrayList<String> list){
        for (String s : list)
        {
            if (s.equals("b"))
            {
                list.remove(s);
            }
        }
    }

}
