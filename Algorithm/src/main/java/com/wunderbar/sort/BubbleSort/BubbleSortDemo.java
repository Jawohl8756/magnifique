package com.wunderbar.sort.BubbleSort;

/**
 * @author Rommel
 * @date 2021/3/1 22:34
 * @description 冒泡场景测试
 */
public class BubbleSortDemo {

    public static void main(String[] args) {
        int[] array = {42, 20, 17, 13, 28, 14, 23, 15};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(array);
        System.out.println("before BubbleSort,source Array={42, 20, 17, 13, 28, 14, 23, 15}");

        System.out.println("after BubbleSort ,new Array={");
        for (int num : array) {
            System.out.println(num + "");
        }
        System.out.println("}");

    }
}
