package com.wunderbar.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Rommel
 * @date 2021/1/11 20:43
 * @description
 */
public class EmptyListDemo {

    public static void main(String[] args) {
        List<String> list = Collections.emptyList();
        list.add("ich");
        System.out.println("list = " + list);
    }
}
