package com.wunderbar.datastructure.map;/**
 *
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author katze
 * @date 2020/7/29 15:07
 * @description 数组中元素是否唯一
 * 要求时间复杂度O(f(n))
 */
public class ElementUniqueInArrayDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 ,2};
        boolean isUniquElement = isUniquElement(arr);
        if (isUniquElement) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    public static boolean isUniquElement(int[] arr) {
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (d.containsKey(arr[i])) {
                return false;
            }
            d.put(arr[i], 1);
        }
        return true;
    }

}
