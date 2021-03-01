package com.wunderbar.sort.BubbleSort;

/**
 * @author Rommel
 * @date 2021/3/1 22:35
 * @description 冒泡排序 (ASC升序)
 */
public class BubbleSort {

    //数组的最小长度，小于等于2，就不用排序了
    public static final int MIN_COUNT = 2;

    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] source) {
        //对参数进行校验，不符合要求的直接返回
        if (source == null || source.length <= MIN_COUNT) {
            return;
        }

        //外层套要循环:source.length-1次
        for (int i = 0; i < source.length - 1; i++) {
            //内层要循环:外层数量-i次
            for (int j = 0; j < source.length - 1 - i; j++) {

                //如果前面的数比后面的数大，那就引入临时变量tmp，赋值并交换
                if (source[j] > source[j + 1]) {
                    /**
                     * 1.前面的数大，赋值给临时变量tmp
                     *   int tmp =source[j]
                     * 2.后面小的值赋给前面的
                     *   source[j]=source[j+1]
                     * 3.最后临时变量赋值给后面的source[j+1]
                     *   source[j+1]=tmp
                     */
                    int tmp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = tmp;

                }
            }

        }


    }
}
