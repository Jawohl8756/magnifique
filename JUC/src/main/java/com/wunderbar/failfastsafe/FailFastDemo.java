package com.wunderbar.failfastsafe;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rommel
 * @date 2020/3/6 11:40
 * @description 快速失败
 * <p>
 * 高并发线程下，线程不安全，add ,remove ,update
 * ConcurrentModifiedException
 */

public class FailFastDemo {

    public static void main(String[] args) {


        List<String> userNames = new ArrayList<String>() {
            {
                add("James");
                add("Jame");
                add("Jaes");
                add("Jamey");
                add("Hames");
            }
        };

        userNames.iterator();

        for (String userName : userNames) {
            if (userName.equals("Jamey")) {
                userNames.remove(userName);
            }
            System.out.println(userNames);
        }
    }
}
