package com.wunderbar.collection;/**
 *
 */

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author katze
 * @date 2020/8/3 13:22
 * @description HashMap在多线程条件下，并不是线程安全的
 */
public class HashMapNotThreadSafeDemo {


    public static void main(String[] args) {
                final Map<Integer, String> map = new HashMap<>();
         
                final Integer targetKey = 0b1111_1111_1111_1111; // 65 535
                final String targetValue = "v";
                map.put(targetKey, targetValue);
         
                new Thread(() -> {
                    IntStream.range(0, targetKey).forEach(key -> map.put(key, "someValue"));
                }).start();
         
                while (true) {
                    if (null == map.get(targetKey)) {
                        throw new RuntimeException("HashMap is not thread safe.");
                    }
                }
            }
        }
