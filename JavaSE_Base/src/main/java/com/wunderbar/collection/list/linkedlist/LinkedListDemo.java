package com.wunderbar.collection.list.linkedlist;

import java.util.LinkedList;

/**
 * @author Rommel
 * @date 2021/1/2 15:15
 * @description 链表List,保存head Node ,指向next Node 。尾节点指向Null
 *
 * 查询复杂度O(N)，需要一个一个遍历
 * 删除复杂度O(1)
 *
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list =new LinkedList<>();
        list.add("wenn");
        list.add("du");
        list.add("mich");
        list.add("noch");
        list.add("einmal");
        list.add("anmachst");
        list.add("lasse");
        list.add("ich");
        list.add("dich");
        list.add("feuern");

        System.out.println("Before This LinkedList is:"+list);

        System.out.println("After This LinkedList is:"+list);
    }
}
