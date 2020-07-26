package com.wunderbar.failfastsafe;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Rommel
 * @date 2020/3/6 11:55
 * @description 安全失败
 * 当ArrayList,HashSet ,HashMap在多线程情况下都是线程不安全的
 * 那就是用CopyOnWrite思想
 *
 * ArrayList                        CopyOnWriteArrayList
 * HashSet(底层是HashMap)            CopyOnWriteArraySet
 * HashMap                           ConcurrentHashMap
 *
 */
public class FailSafeDemo {

    public static void main(String[] args) {
        List<String> userNames = new CopyOnWriteArrayList<String>(){
            {
                add("take");
                add("make");
                add("jake");
                add("wake");
                add("fake");
            }
        };

        for (String username:userNames){
            if (username.equals("wake")){
                userNames.remove(username);
            }
            System.out.println(userNames);
        }
    }
}
